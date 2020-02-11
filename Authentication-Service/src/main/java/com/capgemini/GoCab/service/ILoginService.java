package com.capgemini.GoCab.service;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.entity.User;
import com.capgemini.GoCab.dto.LoginUser;

@Service
public interface ILoginService {

	String login(String username, String password);
   // LoginUser saveUser(LoginUser user);

   // boolean logout(String token);

    Boolean isValidToken(String token);

    String createNewToken(String token);
	String createUser(LoginUser user);
}
