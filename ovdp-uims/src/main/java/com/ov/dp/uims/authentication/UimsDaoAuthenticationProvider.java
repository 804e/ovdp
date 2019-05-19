package com.ov.dp.uims.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * 自定义校验器<br/>
 * 覆盖方法authenticate，让错误信息更友好
 * 
 * @author wangweifeng
 *
 */
public class UimsDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	private MessageSource messageSource;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
				messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports",
						"Only UsernamePasswordAuthenticationToken is supported"));

		// Determine username
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

		boolean cacheWasUsed = true;
		UserDetails user = getUserCache().getUserFromCache(username);

		if (user == null) {
			cacheWasUsed = false;

			try {
				user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
			} catch (UsernameNotFoundException notFound) {
				logger.debug("User '" + username + "' not found");

				if (hideUserNotFoundExceptions) {
					throw new BadCredentialsException(messageSource.getMessage(
							"ucas.auth.fail.AccountNotFoundException", null, LocaleContextHolder.getLocale()));
				} else {
					throw notFound;
				}
			}

			Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
		}

		try {
			getPreAuthenticationChecks().check(user);
			additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
		} catch (AuthenticationException exception) {
			if (cacheWasUsed) {
				// There was a problem, so try again after checking
				// we're using latest data (i.e. not from the cache)
				cacheWasUsed = false;
				user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
				getPreAuthenticationChecks().check(user);
				additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
			} else {
				throw exception;
			}
		}

		getPostAuthenticationChecks().check(user);

		if (!cacheWasUsed) {
			getUserCache().putUserInCache(user);
		}

		Object principalToReturn = user;

		if (isForcePrincipalAsString()) {
			principalToReturn = user.getUsername();
		}

		return createSuccessAuthentication(principalToReturn, authentication, user);
	}

}
