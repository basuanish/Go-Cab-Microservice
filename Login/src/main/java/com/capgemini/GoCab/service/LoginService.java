package com.capgemini.GoCab.service;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.UserDTO;
import com.capgemini.GoCab.exceptions.LoginExceptions;

@Service
public interface LoginService {

	public boolean validateEmail(UserDTO login) throws LoginExceptions;
}
