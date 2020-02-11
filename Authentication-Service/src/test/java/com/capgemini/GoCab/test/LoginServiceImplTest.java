package com.capgemini.GoCab.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.GoCab.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoginServiceImplTest {


	@Autowired
	UserService userService;
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		userService=null;
	}

	@Test
	@DisplayName("Login Successful")
	@Rollback(true)
	void testAuthenticateUser(){
		
		String username = "8961579177";
		String password = "12345";
		assertTrue(userService.authenticateUser(username,password));
	}
	
	
	@Test
	@DisplayName("Login Failed")
	@Rollback(true)
	void testAuthenticateUserFail(){
		
		String username = "8211579177";
		String password = "1234";
		assertFalse(userService.authenticateUser(username,password));
		
	}
}
