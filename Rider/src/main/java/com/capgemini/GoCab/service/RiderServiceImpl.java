package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dao.RiderDAO;
import com.capgemini.GoCab.dto.Rider;
import com.capgemini.GoCab.entity.RiderEntity;

@Service
public class RiderServiceImpl implements RiderService {

	
	@Autowired
	RiderDAO riderDAO;
	
	@Override
	public String addRider(Rider rider) {
		RiderEntity riderEntity=new RiderEntity();
		System.out.println(rider);
		riderEntity.setEmail(rider.getEmail());
		riderEntity.setName(rider.getName());
		riderEntity.setPhoneNumber(rider.getPhoneNumber());
		riderEntity.setCity(rider.getCity());
		riderEntity.setZipcode(rider.getZipcode());
		riderDAO.save(riderEntity);
		return "Rider Added" ;
	}

}
