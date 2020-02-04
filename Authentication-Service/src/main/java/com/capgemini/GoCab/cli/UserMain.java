package com.capgemini.GoCab.cli;
//package com.ss.sflbackend.cli;
//
//import java.util.Scanner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ss.sflbackend.service.UserService;
//import com.ss.sflbackend.service.UserServiceImpl;
//
//public class UserMain {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Welcome");
//		System.out.println("*******************************************");
//		System.out.println("Enter your username(Email Address)");
//		String username = scanner.next();
//		System.out.println("Enter password:");
//		String password = scanner.next();
//		
//		System.out.println("********************************************");
//		
//		UserServiceImpl uiService = new UserServiceImpl();
//		if(uiService.authenticateUser(username, password))
//			System.out.println("Login successful");
//		else
//			System.out.println("Login Failed");
//		
//	}
//
//}
