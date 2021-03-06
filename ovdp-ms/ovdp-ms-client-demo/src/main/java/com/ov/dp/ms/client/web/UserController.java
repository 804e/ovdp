package com.ov.dp.ms.client.web;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ov.dp.auth.dto.User;
import com.ov.dp.ms.client.service.UmisClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Api("springcloud consumer user 控制器")
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UmisClientService umisClientService;

	/**
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = User.class)
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod = "userFallbackMethod")
	public User getUser(@ApiParam(name = "id", required = true, value = "用户Id") @PathVariable String id) {
		/*return this.restTemplate.getForObject("http://ovdp-ms-server-demo/user/" + id, User.class);*/
		User user = this.umisClientService.getUser(id);
		return user;
	}

	public User userFallbackMethod(String id) {
		return null;
	}

	/**
	 * 这块ribbon不支持复杂数据类型list，所以要用数组接受，然后转list
	 * @return
	 */
	@GetMapping("/list")
	@HystrixCommand(fallbackMethod = "userList")
	public List<User> users() {
		try {
			HttpHeaders headers = new HttpHeaders();
			String auth = "root:fdsajkl;";
			byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String(encodedAuth);
			headers.set("Authorization", authHeader);
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<String> forObject = this.restTemplate.exchange("http://ovdp-ms-server-demo/user/all",
					HttpMethod.GET, entity, String.class);
			List<User> users = Lists.newArrayList();
			return users == null ? new ArrayList<User>() : users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> userList() {
		return null;
	}

	/**
	 * 通过服务id获取服务的地址
	 * @return
	 */
	@GetMapping("ribbon")
	public String ribbon() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("ovdp-ms-server-demo");
		return serviceInstance.getUri().toString();
	}
}