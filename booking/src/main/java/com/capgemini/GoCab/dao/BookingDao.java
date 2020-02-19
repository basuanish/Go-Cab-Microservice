package com.capgemini.GoCab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.entity.Booking;


@Repository
public interface BookingDao extends JpaRepository<Booking,Integer>{

	public List<Booking> findBySourceAndDestination(String source, String destination);
	

}
