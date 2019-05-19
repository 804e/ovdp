package com.ov.dp.uims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户信息管理系统启动类
 * 
 * @author overfight
 *
 */
@SpringBootApplication
@ComponentScan("com.ov.dp")
public class UimsApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(UimsApplication.class, args);
    }

}
