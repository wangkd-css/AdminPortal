package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.UserModel;


@Mapper
//@Component
public interface UserDao {
	
	public List<UserModel> getUserList();
	
	public int deleteUser(String userId);

	public int addUser(UserModel user);

	public int updateUser(UserModel user);

	public UserModel getUserById(@Param("userId") String userId);
	
//	public int resetUser(@Param("userId") String userId , @Param("password") String password );
	
	public int changePassword(UserModel user);
}
