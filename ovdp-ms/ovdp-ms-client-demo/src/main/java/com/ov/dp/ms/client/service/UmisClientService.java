package com.ov.dp.ms.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ov.dp.auth.dto.User;

/**
 * uims api调用接口
 * 
 * @author overfight
 *
 */
@FeignClient("uims")
public interface UmisClientService {

	/**
	 * 用户api<br/>
	 * 被调用方如果有contextpath，一定要加上
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/uims/api/user/{id}")
	public User getUser(@PathVariable("id") String id);

}
