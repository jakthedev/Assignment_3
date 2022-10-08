package com.coderscampus.myapp.service;

import com.coderscampus.assignment_3.User;

public class UserService {
	
	public static User createUser(String username, String password, String name) {
		User user = new User(); 
		user.setUsername(username); 
		user.setPassword(password); 
		user.setName(name);
		return user;
	}

}
