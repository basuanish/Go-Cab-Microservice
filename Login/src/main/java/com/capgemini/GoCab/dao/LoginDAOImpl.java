package com.capgemini.GoCab.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.GoCab.dto.UserDTO;
import com.capgemini.GoCab.exceptions.LoginExceptions;
import com.capgemini.GoCab.model.User;
import com.capgemini.GoCab.repository.LoginRepository;

@Component
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	LoginRepository loginRepo;

	@Override
	public String validateEmail(UserDTO login) throws LoginExceptions {
		String secretKey = null;
		Optional<User> loginRequested = loginRepo.findById(login.getPhoneNumber());

		if (loginRequested.isPresent()) {
			secretKey = loginRequested.get().getSecretKey();
		} else {
			throw new LoginExceptions("NO_SUCH_ACCOUNT");

		}
		return secretKey;
	}

	@Override
	public String fetchPassword(UserDTO login) throws LoginExceptions {
		String password = null;
		Optional<User> loginRequested = loginRepo.findById(login.getPhoneNumber());

		if (loginRequested.isPresent()) {
			password = loginRequested.get().getPassword();
		} else {
			throw new LoginExceptions("LOGIN_ERROR");
		}
		return password;

	}

}
