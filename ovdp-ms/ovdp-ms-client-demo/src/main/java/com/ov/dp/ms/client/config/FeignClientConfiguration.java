package com.ov.dp.ms.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import com.google.common.collect.Lists;

import feign.Logger;
import feign.RequestInterceptor;

/**
 * feign客户端相关配置
 * 
 * @author overfight
 *
 */
@Configuration
public class FeignClientConfiguration {
	
	@Value("${security.oauth2.demo.grant-type}")
    private String grantType;
	
	@Value("${security.oauth2.demo.access-token-uri}")
    private String accessTokenUri;

    @Value("${security.oauth2.demo.client-id}")
    private String clientId;

    @Value("${security.oauth2.demo.client-secret}")
    private String clientSecret;

    @Value("${security.oauth2.demo.scope}")
    private String scope;
    
    @Bean
    RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
    }

    OAuth2ProtectedResourceDetails resource() {
    	ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
//    	details.setId("client-demo");
        details.setAccessTokenUri(accessTokenUri);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setScope(Lists.newArrayList(scope));
        details.setGrantType(grantType);
//        details.username = 'theUser1'
//        details.password = 'theResourceOwnerPassword'
        return details;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
