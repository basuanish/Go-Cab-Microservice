package com.capgemini.GoCab.service;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.Driver;

@Service
public interface DriverService {
	
	public String addDriver(Driver driver);

}
