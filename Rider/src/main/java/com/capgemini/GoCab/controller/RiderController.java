package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.GoCab.dto.Rider;
import com.capgemini.GoCab.dto.User;
import com.capgemini.GoCab.service.RiderService;


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
		newUser.setUserFullName(rider.getName());
		newUser.setUserEmailAddress(rider.getEmail());
		newUser.setUserMobileNo(rider.getPhoneNumber());
		newUser.setUserPassword(rider.getPassword());
		newUser.setUserRole("Rider");
		System.out.println(rider);
        String isAdded = riderService.addRider(rider);
        
        String result = restTemplate.postForObject("http://login-service/user/create", newUser,String.class);
        return isAdded;
    }
}
