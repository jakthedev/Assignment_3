package com.coderscampus.assignment_3;

import com.coderscampus.myapp.service.UserService;

public class UserValidationWithCSVFile {

	public static void main(String[] args) {
		UserService userservice = new UserService(); 
		
		User[] users = new User[0];

		for (int i = 0; i < 0; i++) {
		users[i] = userservice.createUser("trevor@craftycodr.com", "test123", "trevor");
		
		}
		System.out.println(users);
	}

}
