package com.ov.dp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ov.dp.auth.entity.UserEntity;
import com.ov.dp.auth.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/add")
	public String addNewUser(@RequestParam String account, @RequestParam String name, @RequestParam String email) {
		UserEntity user = new UserEntity();
		user.setAccount(account);
		user.setName(name);
		user.setEmail(email);
		userService.save(user);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public Iterable<UserEntity> getAllUsers() {
		return userService.findAll();
	}
}
