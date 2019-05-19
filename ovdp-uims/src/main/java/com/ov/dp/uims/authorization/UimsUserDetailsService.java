package com.ov.dp.uims.authorization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ov.dp.uims.entity.UserDO;
import com.ov.dp.uims.service.UserService;

/**
 * 用户信息、权限加载
 * 
 * @author wangweifeng
 *
 */
@Service
public class UimsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDO user = userService.findByAccount(username);
		if (null == user) {
			throw new UsernameNotFoundException("无法找到该用户");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		// 把角色和权限标识放一起，角色使用固定前缀和权限标识区分
		/*user.getRoleList().stream()
				// 角色
				.peek(role -> authorities.add(new SimpleGrantedAuthority(UcasConstant.ROLE_PREFIX + role.getCode())))
				.flatMap(role -> role.getFuncList().stream())
				// 菜单
				.forEach(menu -> authorities.add(new SimpleGrantedAuthority(menu.getPermission())));*/

		return new User(user.getAccount(), user.getPassword(), authorities);
	}

}
