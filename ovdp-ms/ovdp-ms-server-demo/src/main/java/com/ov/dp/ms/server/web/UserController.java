package com.ov.dp.ms.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ov.dp.ms.server.config.DemoServerConfig;

@RefreshScope
@RestController
@RequestMapping(path = "/user")
public class UserController {
	
//	@Autowired
//    DemoServerConfig config;


	@GetMapping(path = "/add")
	public String addNewUser(@RequestParam String account, @RequestParam String name, @RequestParam String email) {
		return "Saved"/* + config.getTitle()*/;
	}

	@GetMapping(path = "/all")
	public String getAllUsers() {
		return "all";
	}
}
