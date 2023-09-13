package com.rmc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmc.model.BaseModel;
import com.rmc.model.UserModel;
import com.rmc.service.UserService;
import com.rmc.utils.TextUtils;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ResponseBody
	@RequestMapping("/userList")
	public BaseModel getUserList(HttpServletRequest request) {
		List<UserModel> models = userService.getUserList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	
	@ResponseBody
	@RequestMapping("/addUser")
	public BaseModel addUser(HttpSession session, UserModel user) {
		if (user == null) {
			return makeModel(ERROR_CODE, "用户不能为空");
		} else {
			if (user.getUserId() == null || user.getPassword() == null) {
				return makeModel(ERROR_CODE, "用户名或者密码不能为空");
			}

			if (userService.getUserById(user.getUserId()) == null) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				int code = userService.addUser(user);
				if (code == 0) {
					return makeModel(code, MSG_ADD_ERROR);
				} else {
					return makeModel(code, MSG_ADD_SUCC);
				}
			} else {
				return makeModel(ERROR_CODE, "用户名已存在");
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/deleteUser")
	public BaseModel deleteUser(HttpSession session, String userId) {
		
		if (TextUtils.isEmpty(userId)) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		} else {
			int code = userService.deleteUser(userId);
			if (code == 0) {
				return makeModel(code, MSG_DELETE_ERROR);
			} else {
				return makeModel(code, MSG_DELETE_SUCC);
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/getUser")
	public BaseModel getUser(String userId) {
		UserModel models = userService.getUserById(userId);
		if (models == null || models.getUserId() == null) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping(value ="/updateUser", method = RequestMethod.POST)
	public BaseModel updateUser(HttpSession session,  UserModel user) {
		
		if (user.getUserId() == null) {
			return makeModel(ERROR_CODE, "请输入用户情报。");
		}else {
			int code = userService.updateUser(user);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/resetUser")
	public BaseModel resetUser(HttpSession session, String userId) {
		
		if (TextUtils.isEmpty(userId)) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		}else {
			UserModel user = new UserModel();
			user.setUserId(userId);
			user.setPassword(passwordEncoder.encode("admin"));
			int code = userService.changePassword(user);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value ="/changePassword", method = RequestMethod.POST)
	public BaseModel changePassword(HttpSession session,  UserModel user) {
		
		if (user.getUserId() == null) {
			return makeModel(ERROR_CODE, "请输入用户情报。");
		}else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			int code = userService.changePassword(user);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
}
