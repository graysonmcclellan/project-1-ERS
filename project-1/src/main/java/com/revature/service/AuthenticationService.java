package com.revature.service;

import com.revature.model.User;

public class AuthenticationService {

	public static boolean isValidUser(String username, String password) {
		
		UserService us = new UserService();
		
		int userId = us.checkUsernameAndPassword(username, password);
		
		if(userId==0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public static User getCurrentUserByUsername(String username) {
		UserService us = new UserService();
		
		
		User curr = us.getUserByUsername(username);
		return curr;
	}
	
}
