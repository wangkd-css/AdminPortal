package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.UserDao;
import com.rmc.model.UserModel;


@Service
public class UserService {
//	@Resource
	@Autowired
	UserDao userdao;

	public List<UserModel> getUserList() {
		return userdao.getUserList();
	}

	public UserModel getUserById(String id) {
		return userdao.getUserById(id);
	}

//	public int resetUser(String id,String password) {
//		return userdao.resetUser(id,password);
//	}
	
	public int addUser(UserModel user) {
		return userdao.addUser(user);
	}
//
	public int deleteUser(String id) {
		return userdao.deleteUser(id);
	}

	public int updateUser(UserModel user) {
		return userdao.updateUser(user);
	}
	
	public int changePassword(UserModel user) {
		return userdao.changePassword(user);
	}
}
