package com.keven.springDemo.service;

import java.util.List;

import com.keven.springDemo.model.Permission;
import com.keven.springDemo.model.Role;
import com.keven.springDemo.model.User;

public interface UserService {
	
	List<Role> findRoles(Integer id);
	
	List<Permission> findPermissions(Integer id);
	
	User findUserById(String uId);
	
	int assignDefaultUserRolePermission(User user);
	
	List<User> findAllUsers();
	
	List<User> findUsersByNameAndPWD(String name,String password);
	
	int updateUserInfo(User user);
	
}
