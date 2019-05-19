package com.ov.dp.uims.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * spring security oauth2认证服务器相关配置
 * 
 * @author wangweifeng
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Resource
	private DataSource dataSource;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * 配置授权服务器的安全，打开/oauth/token入口，其它入口需要配置
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients().checkTokenAccess("isAuthenticated()")// 打开/oauth/check_token入口
		;
	}

	/**
	 * 客户端列表配置
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
	}

	/**
	 * 授权服务器非安全特性，token存储、token自定义、授权类型
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)// url用户密码模式支持
				.tokenStore(tokenStore());// token存储方式
		/*endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST).tokenStore(tokenStore())
		        .tokenEnhancer(tokenEnhancer()).userDetailsService(userDetailsService)
		        .authenticationManager(authenticationManager).reuseRefreshTokens(false)
		        .exceptionTranslator(new PigWebResponseExceptionTranslator());*/
		super.configure(endpoints);
	}

	/**
	 * token存储方式
	 * 
	 * @return
	 */
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
}