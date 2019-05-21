package com.ov.dp.ms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ov.dp.ms.client.config.RibbonConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClients(value = { @RibbonClient(name = "UIMS", configuration = RibbonConfiguration.class),
		@RibbonClient(name = "ovdp-demo", configuration = RibbonConfiguration.class)})
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExtendRibbon.class) })
//@EnableHystrix
@EnableSwagger2
@EnableOAuth2Sso
@EnableFeignClients
public class MsClientApplication {
	
	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MsClientApplication.class, args);
	}
}
