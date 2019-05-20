package com.ov.dp.ms.server.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableOAuth2Sso
public class DemoServerConfig extends WebSecurityConfigurerAdapter {

	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and()
                // 注销配置，注销成功后转到单点登录重点注销链接
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))// 默认是开启了csrf保护的，如果不添加此配置的话，logout就需要发起post请求才可以
                .logoutSuccessUrl("/");
    }

}
