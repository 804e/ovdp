package com.ov.dp.uims.web;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ov.dp.uims.entity.UserDO;
import com.ov.dp.uims.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

/**
 * 用户信息访问接口
 * 
 * @author overfight
 *
 */
@Api("用户信息访问接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "用户列表", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = UserDO.class)
	@GetMapping("/")
	public Iterable<UserDO> list() {
		return this.userService.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = UserDO.class)
	@GetMapping("/{id}")
	public UserDO getUser(@ApiParam(name = "id", required = true, value = "用户Id") @PathVariable BigInteger id) {
		return this.userService.findOne(id);
	}

}
