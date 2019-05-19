package com.ov.dp.uims.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * 自定义登录错误处理
 * 
 * @author wangweifeng
 *
 */
public class UimsSimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (defaultFailureUrl == null) {
			logger.debug("No failure URL set, sending 401 Unauthorized error");

			response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		} else {
			if (isUseForward()) {
				request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception.getMessage());
			} else {
				HttpSession session = request.getSession(false);

				if (session != null || isAllowSessionCreation()) {
					request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception.getMessage());
				}
			}

			if (isUseForward()) {
				logger.debug("Forwarding to " + defaultFailureUrl);

				request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
			} else {
				logger.debug("Redirecting to " + defaultFailureUrl);
				getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
			}
		}
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

}
