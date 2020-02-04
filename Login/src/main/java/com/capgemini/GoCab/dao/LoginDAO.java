package com.capgemini.GoCab.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.dto.UserDTO;
import com.capgemini.GoCab.exceptions.LoginExceptions;

@Repository
public interface LoginDAO {

	public String validateEmail(UserDTO login) throws LoginExceptions;

	public String fetchPassword(UserDTO login) throws LoginExceptions;
}
