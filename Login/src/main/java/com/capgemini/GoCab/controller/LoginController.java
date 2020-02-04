package com.capgemini.GoCab.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dto.UserDTO;
import com.capgemini.GoCab.exceptions.LoginExceptions;
import com.capgemini.GoCab.service.LoginService;
import com.google.gson.JsonObject;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/login")

	public String validateEmail(@RequestBody Map<String, Object> requestData) {
		UserDTO login = new UserDTO();
		JsonObject dataResponse = new JsonObject();

		String phoneNumber = requestData.get("phoneNumber").toString();
		String password = requestData.get("password").toString();

		login.setPassword(password);
		login.setPhoneNumber(phoneNumber);

		try {
			boolean isValidated = loginService.validateEmail(login);
			dataResponse.addProperty("success", true);
			//dataResponse.addProperty("message", Constants.LOGIN_SUCCESSFUL);
			dataResponse.addProperty("Login Id", isValidated);

		} catch (LoginExceptions e) {
			dataResponse.addProperty("success", false);
			dataResponse.addProperty("message", e.getMessage());
		}
		return dataResponse.toString();
	}

}
