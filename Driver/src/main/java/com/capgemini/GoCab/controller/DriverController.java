package com.capgemini.GoCab.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.GoCab.dto.Driver;
import com.capgemini.GoCab.dto.LoginUser;
import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.service.DriverService;
import com.google.gson.JsonObject;

@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(path="/driver")
@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value="/add")
    public String addDriver(@RequestBody Driver driver) {
		JsonObject dataResponse = new JsonObject();
		User newUser = new User();
		LoginUser loginUser = new LoginUser();
		newUser.setUserFullName(driver.getName());
		newUser.setUserEmailAddress(driver.getEmail());
		newUser.setUserMobileNo(driver.getPhoneNumber());
		newUser.setUserPassword(driver.getPassword());
		newUser.setUserRole("Driver");
		
		String isAdded = driverService.addDriver(driver);
		dataResponse.addProperty("success", true);
		dataResponse.addProperty("message", isAdded);
		loginUser.setEmail(driver.getEmail());
        loginUser.setName(driver.getName());
        loginUser.setPassword(driver.getPassword());
        Set<String> Role_Set = new HashSet<String>(); 
        Role_Set.add("Driver");
        loginUser.setRole(Role_Set);
		String result = restTemplate.postForObject("http://API-Gateway/api/create", loginUser,String.class);
        return dataResponse.toString();
    }
	
	@GetMapping(value="/all")
	public List<Driver> getAllDrivers(){
		List<Driver> all = new ArrayList<Driver>();
		all = driverService.getAllDrivers();
		return all;
		
	}
	
	@DeleteMapping(path ={"/{phoneNumber}"})
    public boolean delete(@PathVariable("phoneNumber") String phoneNumber) {
        return driverService.delete(phoneNumber);
    }

}
