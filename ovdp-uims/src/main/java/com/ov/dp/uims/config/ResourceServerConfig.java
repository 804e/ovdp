package com.ov.dp.uims.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * oauth resource server配置 uims也提供用户菜单角色相关api
 * 
 * @author wangweifeng
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/api/**", "/principal")//必需设置，否则会被UcasSecurityConfig里面的配置覆盖导致无法正确配置oauth2端点
        .and().authorizeRequests().antMatchers("/api/**", "/principal").authenticated();
    }
}