package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dao.BookingDao;
import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	@Override
	public String addBooking(BookingDTO booking) {
		
		Booking bookingEntity=new Booking();
		bookingEntity.setBookingId(booking.getBookingId());
		bookingEntity.setCabType(booking.getCabType());
		bookingEntity.setDestination(booking.getDestination());
		bookingEntity.setSource(booking.getSource());
		bookingDao.save(bookingEntity);
		return "booking done successfully";
		
		
	}

}
