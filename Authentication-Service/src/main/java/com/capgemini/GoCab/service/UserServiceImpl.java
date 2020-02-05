/**
 * Service layer implemetation
 */
package com.capgemini.GoCab.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.GoCab.dao.ILoginDao;
import com.capgemini.GoCab.dao.IUserDao;
import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.entity.LoginEntity;
import com.capgemini.GoCab.entity.UserEntity;
import com.capgemini.GoCab.exception.UserNotFoundException;
import com.capgemini.GoCab.exception.UserNotSavedException;

/**
 
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ILoginDao loginDao;

	@Override
	public String createUser(User user) throws UserNotSavedException {
		
		System.out.println(user);
		String encodedPassword = passwordEncoder.encode(user.getUserPassword());
		
		// Only username and password will be saved into Login Table
		
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setUsername(user.getUserMobileNo()); // As username is User mobile no
		loginEntity.setPassword(encodedPassword);
		
		loginDao.save(loginEntity);
		
		UserEntity userEntity = new UserEntity();
		
		// Date conversion to string
//		Date date = new Date(user.getUserDob());
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		
		
		//Only user data without password will be saved into User Table
		
		userEntity.setUserEmailAddress(user.getUserEmailAddress());
		userEntity.setUserFullName(user.getUserFullName());
		userEntity.setUserMobileNo(user.getUserMobileNo());
//		userEntity.setDob(converttoDateString(user.getUserDob()));
		userEntity.setUserRole(user.getUserRole());
		userDao.save(userEntity);
		
		return "User added";
	}
	
	

//	@Override
//	public boolean deleteUser(int userId) {
//		String userEmail = userDao.findUserEmailByUserId(userId);
//		loginDao.deleteById(userEmail);
//		userDao.deleteById(userId);
//		return true;
//	}

//	@Override
//	public User updateUser(User user) {
//		return userDao.save(user);
//	}
//
//	@Override
//	public List<UserEntity> getAllUsers() {
//		return userDao.findAll();
//	}
//
//	@Override
//	public List<User> findUserByName(String name) {
//		return null;
//	}

	@Override
	public boolean authenticateUser(String username, String password) {
		Optional<LoginEntity> le = loginDao.findById(username);
		if(!le.isEmpty()) {
			if(passwordEncoder.matches(password,le.get().getPassword())) // First argument is data provided by user, second is from database
				return true;	
		}
			
		return false;
	}
	
	
	//Method to Convert milliSeconds to Date
//	public String converttoDateString(Long milliSeconds) {
//		Date date = new Date(milliSeconds);
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		return formatter.format(date);
//	}



	@Override
	public boolean updateUser(UserEntity user) {
		userDao.save(user);
		return false;
	}



//	@Override
//	public UserEntity getInfo(String username) throws UserNotFoundException {
//		return userDao.findUserByUserName(username);
//		
//	}
	
//	@Override
//	public boolean storeProfileImage(MultipartFile file) {
//		return false;
//	}

}
