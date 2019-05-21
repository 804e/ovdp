package com.ov.dp.ms.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.ov.dp")
@EnableFeignClients(basePackages = { "com.ov.dp" })
public class MsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsServerApplication.class, args);
	}

}
