package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dao.DriverDAO;
import com.capgemini.GoCab.dto.Driver;
import com.capgemini.GoCab.entity.DriverEntity;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	DriverDAO driverDAO;

	@Override
	public String addDriver(Driver driver) {
		DriverEntity dE = new DriverEntity();
		dE.setName(driver.getName());
		dE.setAge(driver.getAge());
		dE.setCarNumber(driver.getCarNumber());
		dE.setCarType(driver.getCarType());
		dE.setPhoneNumber(driver.getPhoneNumber());
		
		driverDAO.save(dE);
		return "Driver added";
	}

}
