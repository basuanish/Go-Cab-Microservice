package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.GoCab.dao.RiderDAO;
import com.capgemini.GoCab.dto.Rider;
import com.capgemini.GoCab.entity.RiderEntity;

public class RiderServiceImpl implements RiderService {

	
	@Autowired
	RiderDAO riderDAO;
	RiderEntity riderEntity;
	@Override
	public String addRider(Rider rider) {
		// TODO Auto-generated method stub
		
		riderEntity.setEmailId(rider.getEmailId());
		riderEntity.setName(rider.getName());
		riderEntity.setPhoneNumber(rider.getPhoneNumber());
		riderDAO.save(riderEntity);
		return "rider added" ;
	}

}
