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
		User[] users = new User[3];
		BufferedReader fileReader = null;
		String line;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your email:");
		String userName = scan.nextLine();
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
				if (users[0] != null && users[1] != null && users[2] != null) {
					break;
				}
			}
			
			
			while (t < 6) {
				if (users[0].getUsername().equals(userName) || users[1].getUsername().equals(userName)
						|| users[2].getUsername().equals(userName))
				{
					System.out.println("Welcome " + userName);
					break;
				}  if (users[0].getUsername() != userName || users[1].getUsername() != userName
						|| users[2].getUsername() != userName) 
				{
						System.out.println("Invalid login, please try again");
						userName = scan.nextLine();
						passwordLogin = scan.nextLine();
						t++;
				} if (users[0].getUsername().equals(userName) || users[1].getUsername().equals(userName)
						|| users[2].getUsername().equals(userName))
				{
					System.out.println("Welcome " + userName);
					break;
				}
				if (t == 4) 
				{
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
