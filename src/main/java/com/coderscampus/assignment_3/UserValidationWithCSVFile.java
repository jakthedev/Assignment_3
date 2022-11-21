package com.coderscampus.assignment_3;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.coderscampus.myapp.service.UserService;

public class UserValidationWithCSVFile {

	public static void main(String[] args) {
		User[] users = new User[5];
		BufferedReader fileReader = null;
		String line;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your email:");
		String userName = scan.nextLine();
		userName = userName.toLowerCase();
		System.out.println("Enter password:");
		String passwordLogin = scan.nextLine();
		int t = 0;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] newInfo = line.split(",");
				
				User user = UserService.createUser(newInfo[0], newInfo[1], newInfo[2]);
				users[i] = user;
				i++;
				if (users[0] != null && users[1] != null && users[2] != null && users[3] != null) {
					users[i] = user;
					break;
				}
			}
			while (t < 6) {
				if (users[0].getUsername().equals(userName) && users[0].getPassword().equals(passwordLogin)
						|| users[1].getUsername().equals(userName) && users[1].getPassword().equals(passwordLogin)
						|| users[2].getUsername().equals(userName) && users[2].getPassword().equals(passwordLogin)
						|| users[3].getUsername().equals(userName) && users[3].getPassword().equals(passwordLogin)) {
					for (int d = 0; d < users.length; d++) {
						if (users[d].getUsername().equals(userName)) {
							String name1 = users[d].getName();
							System.out.println("Welcome " + name1);
							break;
						}
					}
					break;
				}
				if (!users[0].getUsername().equals(userName) && !users[0].getPassword().equals(passwordLogin)
						|| !users[1].getUsername().equals(userName) && !users[1].getPassword().equals(passwordLogin)
						|| !users[2].getUsername().equals(userName) && !users[2].getPassword().equals(passwordLogin)
						|| !users[3].getUsername().equals(userName) && !users[3].getPassword().equals(passwordLogin)) {
					System.out.println("Invalid login, please try again");
					System.out.println("Enter your email:");
					userName = scan.nextLine();
					userName = userName.toLowerCase();
					System.out.println("Enter password:");
					passwordLogin = scan.nextLine();
					t++;

				}
				if (users[0].getUsername().equals(userName) && users[0].getPassword().equals(passwordLogin)
						|| users[1].getUsername().equals(userName) && users[1].getPassword().equals(passwordLogin)
						|| users[2].getUsername().equals(userName) && users[2].getPassword().equals(passwordLogin)
						|| users[3].getUsername().equals(userName) && users[3].getPassword().equals(passwordLogin)) {
					for (int j = 0; j < users.length; j++) {
						if (users[j].getUsername().equals(userName)) {
							String name = users[j].getName();
							System.out.println("Welcome " + name);
							break;
						}
					}
					break;
				}
				if (t == 4) {
					System.out.println(" Too many failed login attempts, you are now locked out ");
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was not found ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" There was an I/O exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
