package com.keven.springDemo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	@RequestMapping({ "/", "/login" })
	public String login() {
		return "/login";
	}

	/**
	 * ajax登录请求
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "dologin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(String username, String password, Model model) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {

			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			SecurityUtils.getSubject().login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");

		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}

}
