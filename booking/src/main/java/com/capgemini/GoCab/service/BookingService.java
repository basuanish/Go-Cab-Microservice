package com.capgemini.GoCab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;
@Service
public interface BookingService {

	public String addBooking(BookingDTO booking);

	public Booking generateFare(Booking booking);
	
	public List<Booking> getBookings();
	
	public Booking getRider();
	
	
}
