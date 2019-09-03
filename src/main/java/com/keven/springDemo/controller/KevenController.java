package com.keven.springDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keven.springDemo.entity.User;

@RestController
public class KevenController {

	@RequestMapping("/testChannel")
	public String index() {
		return "SpringDemo服务已连接";
	}

	@RequestMapping("/getuser")
	public User getUser() {
		User user = new User();
		user.setUserid("admin001");
		user.setUsernm("keven");
		user.setUserpw("admin123");
		return user;
	}

}
