package com.capgemini.GoCab.service;

import java.util.ArrayList;
import java.util.List;

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
		dE.setEmail(driver.getEmail());
		dE.setCarNumber(driver.getCarNumber());
		dE.setCarType(driver.getCarType());
		dE.setPhoneNumber(driver.getPhoneNumber());
		
		driverDAO.save(dE);
		return "Driver added";
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> all = new ArrayList<Driver>();
		List<DriverEntity> allEntity = new ArrayList<DriverEntity>();
		Driver driver;
		allEntity = driverDAO.findAll();
		for (DriverEntity entity : allEntity) {
			driver = new Driver();
			driver.setName(entity.getName());
			driver.setAge(entity.getAge());
			driver.setPhoneNumber(entity.getPhoneNumber());
			driver.setCarType(entity.getCarType());
			driver.setCarNumber(entity.getCarNumber());
			all.add(driver);
	}
		return all;
	}
	
	@Override
    public boolean delete(String phoneNumber) {
		DriverEntity tempEntity = null;
		List<DriverEntity> allEntity = new ArrayList<DriverEntity>();
		
		allEntity = driverDAO.findAll();
		
		for (DriverEntity entity : allEntity) {
			if(entity.getPhoneNumber().equals(phoneNumber)) {
				System.out.println(phoneNumber);
				tempEntity = entity;
				//break;
			}
		}
		
		boolean deleteSuccess = false;
		if(tempEntity != null) {
			driverDAO.delete(tempEntity);
			deleteSuccess = true;
		}
		
		return deleteSuccess;
    }
	
}
