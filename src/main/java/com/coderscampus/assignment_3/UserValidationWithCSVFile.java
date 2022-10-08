package com.coderscampus.assignment_3;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.coderscampus.myapp.service.UserService;

public class UserValidationWithCSVFile {
	/**
	 * // Creating method to intake data.txt info and put it in to User.java
	 * varaibles public static String importTxtData (String username, String
	 * password, String name) {
	 * 
	 * // BufferedReader fileReader = null; // // Scanner scan = new
	 * Scanner(System.in); // System.out.println("Enter your email:"); // String
	 * userName = scan.nextLine(); // System.out.println("Enter password:"); //
	 * String passwordLogin = scan.nextLine(); // scan.nextLine();
	 * 
	 * try { fileReader = new BufferedReader(new FileReader("data.txt"));
	 * 
	 * User[] users = new User[3]; String line = ""; while ((line =
	 * fileReader.readLine()) != null) {
	 * 
	 * String[] newInfo = line.split(",");
	 * 
	 * for (String info : newInfo) { System.out.println(info); }
	 * 
	 * } catch (FileNotFoundException e) { System.out.println("File was not found
	 * "); e.printStackTrace(); } catch (IOException e) { System.out.println(" There
	 * was an I/O exception" ); e.printStackTrace(); } finally { try {
	 * fileReader.close(); } catch (IOException e) { e.printStackTrace(); } } } }
	 **/

	public static void main(String[] args) {
		User[] users = new User[3];
		BufferedReader fileReader = null;
		String line;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your email:");
		String userName = scan.nextLine();
		System.out.println("Enter password:");
		String passwordLogin = scan.nextLine();
		int t = 7;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] newInfo = line.split(",");

				User user = UserService.createUser(newInfo[0], newInfo[1], newInfo[2]);
				users[i] = user;
				i++;
				
				if (userName.equals(user.getUsername())) {
					System.out.println("Welcome " + user.getName());
					break;
				}
					else {
					for (int j = 0; j < t; j++) {
					System.out.println("Invalid login, please try again"); 
					userName = scan.nextLine(); 
					passwordLogin = scan.nextLine(); 
					t--;
					
					}
					
				} 
					 if (t < 5) {
						System.out.println("Too many failed login attempts, you are now locked out");
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
