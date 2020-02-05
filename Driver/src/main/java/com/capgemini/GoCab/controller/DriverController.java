package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dto.Driver;
import com.capgemini.GoCab.service.DriverService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/driver")
@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PostMapping(value="/add")
    public String addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

}
