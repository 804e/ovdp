package com.ov.dp.ms.server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {


	@GetMapping(path = "/add")
	public String addNewUser(@RequestParam String account, @RequestParam String name, @RequestParam String email) {
		return "Saved";
	}

	@GetMapping(path = "/all")
	public String getAllUsers() {
		return "all";
	}
}