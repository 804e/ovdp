package com.ov.dp.uims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 用户信息管理系统启动类
 * 
 * @author overfight
 *
 */
@ComponentScan("com.ov.dp")
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class UimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UimsApplication.class, args);
	}

}
