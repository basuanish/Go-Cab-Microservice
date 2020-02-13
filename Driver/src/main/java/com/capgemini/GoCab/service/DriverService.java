package com.capgemini.GoCab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.Driver;
import com.capgemini.GoCab.dto.User;

public interface DriverService {
	
	public String addDriver(Driver driver);

	public List<Driver> getAllDrivers();

	public boolean delete(String phoneNumber);

}
