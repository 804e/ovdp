package com.ov.dp.uims.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录、注销等入口
 * 
 * @author overfight
 *
 */
@Controller
public class SecurityController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 登录页面
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * 首页
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	/**
	 * OAuth2客户端获取的用户信息资源接口
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/principal")
	@ResponseBody
	public Principal principal(Principal principal) {
		return principal;
	}

	/**
	 * 单点登录退出
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("sso/logout")
	public void exit(HttpServletRequest request, HttpServletResponse response, Principal principal) {
		// TODO 根据校验信息撤销token
		//        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) tokenExtractor.extract(request);
		new SecurityContextLogoutHandler().logout(request, null, null);
		try {
			//sending back to client app
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			logger.error("跳转失败", e);
		}
	}
}
