package com.keven.springDemo.service;

import java.util.List;

import com.keven.springDemo.entity.User;

public interface UserService {
	
	public User getUserById(String userId);
	
	boolean addUser(User record);
	
	List<User> selectAllUser();

}
