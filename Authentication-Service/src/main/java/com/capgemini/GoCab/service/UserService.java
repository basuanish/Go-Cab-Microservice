/**
 * Service Layer Interface where business logic would be implemented
 */
package com.capgemini.GoCab.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.entity.UserEntity;
import com.capgemini.GoCab.exception.UserNotFoundException;
import com.capgemini.GoCab.exception.UserNotSavedException;

/**
 * 

 *
 */

public interface UserService {
	
	//Create a user in database
	String createUser(User user) throws UserNotSavedException, IOException;
	
	boolean updateUser(UserEntity user);
	
	//Delete user from database
	//boolean deleteUser(int userId) throws UserNotFoundException;
//	
//	//Update user info in database
//	User updateUser(User user);
//	
	//Get all users from database
	//List<UserEntity> getAllUsers() throws UserNotFoundException;
//	
//	//Get user by name
//	List<User> findUserByName(String name) throws UserNotFoundException;
	
	//Login Authentication
	boolean authenticateUser(String username,String password);

	//UserEntity getInfo(String username) throws UserNotFoundException;
	
	

	
}
