package com.capgemini.GoCab.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.GoCab.dto.LoginUser;
import com.capgemini.GoCab.dto.Rider;
import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.service.RiderService;
import com.google.gson.JsonObject;


@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/rider")
@RestController
public class RiderController {

	@Autowired
	RiderService riderService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path="/add")
    public String addDriver(@RequestBody Rider rider) {
		
		User newUser = new User();
		JsonObject dataResponse = new JsonObject();
		LoginUser loginUser = new LoginUser();
		newUser.setUserFullName(rider.getName());
		newUser.setUserEmailAddress(rider.getEmail());
		newUser.setUserMobileNo(rider.getPhoneNumber());
		newUser.setUserPassword(rider.getPassword());
		newUser.setUserRole("Rider");
        String isAdded = riderService.addRider(rider);
        dataResponse.addProperty("success", true);
		dataResponse.addProperty("message", isAdded);
        loginUser.setEmail(rider.getEmail());
        loginUser.setName(rider.getName());
        loginUser.setPassword(rider.getPassword());
        Set<String> Role_Set = new HashSet<String>(); 
        Role_Set.add("Rider");
        loginUser.setRole(Role_Set);
        String result = restTemplate.postForObject("http://auth-service/api/create", loginUser,String.class);
        return dataResponse.toString();
    }
}
