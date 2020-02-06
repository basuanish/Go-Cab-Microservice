package com.capgemini.GoCab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.GoCab.dto.Driver;
import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.service.DriverService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/driver")
@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value="/add")
    public String addDriver(@RequestBody Driver driver) {
		User newUser = new User();
		newUser.setUserFullName(driver.getName());
		newUser.setUserEmailAddress(driver.getEmail());
		newUser.setUserMobileNo(driver.getPhoneNumber());
		newUser.setUserPassword(driver.getPassword());
		newUser.setUserRole("Driver");
		
		String isAdded = driverService.addDriver(driver);
		//boolean isLoggedIn = false;
		System.out.println(newUser.getUserPassword());
		String result = restTemplate.postForObject("http://login-service/user/create", newUser,String.class);
        return isAdded;
    }
	
	@GetMapping(value="/all")
	public List<Driver> getAllDrivers(){
		List<Driver> all = new ArrayList<Driver>();
		all = driverService.getAllDrivers();
		return all;
		
	}

}
