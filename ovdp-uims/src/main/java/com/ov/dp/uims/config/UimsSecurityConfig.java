package com.ov.dp.uims.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ov.dp.uims.authentication.UimsSavedRequestAwareAuthenticationSuccessHandler;
import com.ov.dp.uims.authentication.UimsDaoAuthenticationProvider;
import com.ov.dp.uims.authentication.UimsPasswordEncoder;
import com.ov.dp.uims.authentication.UimsSimpleUrlAuthenticationFailureHandler;
import com.ov.dp.uims.authorization.UimsUserDetailsService;

/**
 * spring security配置 添加order配置，保证配置在ResourceServerConfig之前生效
 * 
 * @author wangweifeng
 *
 */
@Configuration
@EnableWebSecurity
public class UimsSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UimsUserDetailsService uimsUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/**", "/login/**", "/principal", "/sso/logout").permitAll()
				.anyRequest().authenticated() // 其他地址的访问均需验证权限
				.and().formLogin().loginPage("/login").successHandler(successHandler())
				.failureHandler(authenticationFailureHandler()).and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//默认是开启了csrf保护的，如果不添加此配置的话，logout就需要发起post请求才可以
				.logoutSuccessUrl("/");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/lib/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		UimsPasswordEncoder encoder = new UimsPasswordEncoder("MD5");
		encoder.setCharacterEncoding("UTF-8");
		return encoder;
	}

	/**
	 * web默认校验器
	 * 
	 * @return
	 */
	@Bean
	public UimsDaoAuthenticationProvider authenticationProvider() {
		UimsDaoAuthenticationProvider authenticationProvider = new UimsDaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(uimsUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public UimsSavedRequestAwareAuthenticationSuccessHandler successHandler() {
		UimsSavedRequestAwareAuthenticationSuccessHandler successHandler = new UimsSavedRequestAwareAuthenticationSuccessHandler();
		return successHandler;
	}

	/**
	 * 登录异常处理
	 * 
	 * @return
	 */
	@Bean
	public UimsSimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
		UimsSimpleUrlAuthenticationFailureHandler authenticationFailureHandler = new UimsSimpleUrlAuthenticationFailureHandler();
		authenticationFailureHandler.setDefaultFailureUrl("/login?error");
		authenticationFailureHandler.setUseForward(true);
		return authenticationFailureHandler;
	}

}
