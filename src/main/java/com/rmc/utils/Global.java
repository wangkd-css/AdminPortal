package com.rmc.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;

public class Global {

	public final static String USER_SESSION_KEY = "USER_SESSION_KEY";

	public static String getUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ((User)principal).getUsername();
	}
}
