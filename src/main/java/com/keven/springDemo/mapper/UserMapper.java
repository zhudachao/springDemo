package com.keven.springDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.keven.springDemo.entity.User;

@Component
@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(String userid);
	
	int insert(User record);
	
	int insertSelective(User record);
	 
    User selectByPrimaryKey(String userid);
 
    int updateByPrimaryKeySelective(User record);
 
    int updateByPrimaryKey(User record);
 
    List<User> selectAllUser();

}
