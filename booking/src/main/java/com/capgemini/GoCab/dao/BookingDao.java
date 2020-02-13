package com.capgemini.GoCab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;


@Repository
public interface BookingDao extends JpaRepository<Booking,Integer>{

	public Booking findBySourceAndDestination(String source, String destination);
	

}
