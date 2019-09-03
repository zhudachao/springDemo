package com.keven.springDemo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.keven.springDemo.entity.User;
import com.keven.springDemo.mapper.UserMapper;
import com.keven.springDemo.service.UserService;


@Service("userService")
@Component
public class UserServiceImpl implements UserService{
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
	private UserMapper userDao;
	
	@Override
	public User getUserById(String userid) {		
		return userDao.selectByPrimaryKey(userid);
	}

	@Override
	public boolean addUser(User record) {
		boolean result =false;
		try {
			userDao.insertSelective(record);
			result =true;
		} catch (Exception e) {
            logger.error("数据插入异常：{}",e.getMessage());
		}		
	    return result	;
	}

	@Override
	public List<User> selectAllUser() {
		
		return userDao.selectAllUser();
	}


}
