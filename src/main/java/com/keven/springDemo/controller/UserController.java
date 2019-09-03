package com.keven.springDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.keven.springDemo.entity.User;
import com.keven.springDemo.service.RedisService;
import com.keven.springDemo.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
    @Autowired
	private RedisService redisService;

	private JSONObject json = new JSONObject();

	@RequestMapping("/showUser")
	@ResponseBody
	public String showUser(HttpServletRequest request) {
		User user = null;
		String userId = request.getParameter("userId");
		String result = redisService.get(userId);
		
		if (result == null) {
			user = this.userService.getUserById(userId);
			System.out.println("来自数据库：" + user.getUsernm());
			redisService.set(user.getUserid(), json.toJSONString(user));
		} else {
			System.out.println(result);
			user = JSONObject.parseObject(result, User.class);
			System.out.println("来自redis缓存：" + user.getUsernm());
		}
		return JSONObject.toJSONString(user);
	}

	@RequestMapping("/showListUser")
	@ResponseBody
	public List<User> showListUser(HttpServletRequest request) {
		List<User> userList = null;
		String result = redisService.get("userList");
		if (result == null) {
			userList = userService.selectAllUser();
			System.out.println("来自数据库：" + userList);
			redisService.set("userList", json.toJSONString(userList));
		} else {
			userList = json.parseArray(result, User.class);
			System.out.println("来自redis缓存：" + userList);
		}
		System.out.println(userList);
		return userList;
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public boolean addUser(HttpServletRequest request) {
		User user = null;
		String userId = request.getParameter("userid");
		String userObj = request.getParameter("userObj");
		
		logger.info("新增用户：{},{}",userId, userObj);
		
		boolean result = redisService.set(userId,userObj);
		
		return result;
	}
	@Test
	public  void test() {
		String st ="{\"userpw\":\"sp123456\",\"usernm\":\"springboot\",\"uphone\":\"123\",\"userid\":\"1001\",\"uemail\":\"987@sf.com\"}";
		User user = JSONObject.parseObject(st, User.class);
	    System.out.println(user.toString());
	}
}
