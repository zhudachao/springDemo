package com.keven.springDemo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keven.springDemo.mapper.PermissionMapper;
import com.keven.springDemo.mapper.RoleMapper;
import com.keven.springDemo.mapper.RolePermissionMapper;
import com.keven.springDemo.mapper.UserMapper;
import com.keven.springDemo.mapper.UserRoleMapper;
import com.keven.springDemo.model.Permission;
import com.keven.springDemo.model.PermissionExample;
import com.keven.springDemo.model.Role;
import com.keven.springDemo.model.RoleExample;
import com.keven.springDemo.model.RolePermission;
import com.keven.springDemo.model.RolePermissionExample;
import com.keven.springDemo.model.User;
import com.keven.springDemo.model.UserExample;
import com.keven.springDemo.model.UserRole;
import com.keven.springDemo.model.UserRoleExample;
import com.keven.springDemo.service.UserService;


@Service("userService")
@Component
public class UserServiceImpl implements UserService{
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	
	
	
	@Override
	public List<Role> findRoles(Integer id) {
		 UserRoleExample example = new UserRoleExample();
	        example.createCriteria().andUidEqualTo(id);
	        List<UserRole> userRoleList = userRoleMapper.selectByExample(example);
	        List<Integer> roleIdList = new ArrayList<>(userRoleList.size());
	        for (UserRole userRole : userRoleList) {
	            roleIdList.add(userRole.getRoleId());
	        }
	        RoleExample roleExample = new RoleExample();
	        roleExample.createCriteria().andIdIn(roleIdList);
	        return roleMapper.selectByExample(roleExample);
	}

	@Override
	public List<Permission> findPermissions(Integer id) {
		 List<Role> roles = findRoles(id);
        List<Integer> roleIds = new ArrayList<>(roles.size());
        for (Role role : roles) {
            roleIds.add(role.getId());
        }
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRole_idIn(roleIds);
        List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(example);
        List<Integer> permissionIdList = new ArrayList<>(rolePermissionList.size());
        for (RolePermission rolePermission : rolePermissionList) {
            permissionIdList.add(rolePermission.getPermission_id());
        }
        PermissionExample permissionExample = new PermissionExample();
        if (permissionIdList.size() != 0) {
            permissionExample.createCriteria().andIdIn(permissionIdList);
            return permissionMapper.selectByExample(permissionExample);
        }
        return new ArrayList<>();
    }

    public User findUserById(String uId) {
        return userMapper.selectByPrimaryKey(Integer.valueOf(uId));
    }

    @Transactional
    public int assignDefaultUserRolePermission(User user) {
		int success1 = userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUid(user.getUid());
        userRole.setRoleId(2);
        int success2 = userRoleMapper.insert(userRole);
        return success1 + success2;
    }

	@Override
	public List<User> findAllUsers() {
		UserExample example =new UserExample();
		example.createCriteria().andUidIsNotNull();		
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> findUsersByNameAndPWD(String name, String password) {
		UserExample example =new UserExample();
		example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
		return userMapper.selectByExample(example);
	}

	@Override
	public int updateUserInfo(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}
