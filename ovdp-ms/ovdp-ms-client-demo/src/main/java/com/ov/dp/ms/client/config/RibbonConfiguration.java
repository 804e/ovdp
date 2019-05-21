package com.ov.dp.ms.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonConfiguration {

	/**
	 * 随机
	 * 
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}