package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dto.Rider;
import com.capgemini.GoCab.service.RiderService;


@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/rider")
@RestController

public class RiderController {

	@Autowired
	RiderService riderService;
	
	@PostMapping(value="/add")
    public String addDriver(@RequestBody Rider rider) {
     
        return riderService.addRider(rider);
    }
}
