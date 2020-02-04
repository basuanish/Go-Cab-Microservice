package com.capgemini.GoCab.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.Util.Utility;
import com.capgemini.GoCab.dao.LoginDAO;
import com.capgemini.GoCab.dto.UserDTO;
import com.capgemini.GoCab.exceptions.LoginExceptions;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;

	@Override
	public boolean validateEmail(UserDTO login) throws LoginExceptions {
		boolean isValidated = false;

		String password = null;
		String secretKey = loginDAO.validateEmail(login);
		if (secretKey == null) {
			throw new LoginExceptions("LOGIN_ERROR");
		} else {
			byte arr[] = null;
			try {
				arr = Utility.getSHA(login.getPassword() + secretKey);
			} catch (NoSuchAlgorithmException e) {
				throw new LoginExceptions("LOGIN_ERROR");
			}
			String hashPassword = Utility.toHexString(arr);
			try {
				password = loginDAO.fetchPassword(login);
				if (password.equals(hashPassword)) {
					isValidated = true;
				} else {
					throw new LoginExceptions("LOGIN_ERROR");
				}
			} catch (LoginExceptions e) {
				throw new LoginExceptions("LOGIN_ERROR");
			}
		}
		return isValidated;
	}

}
