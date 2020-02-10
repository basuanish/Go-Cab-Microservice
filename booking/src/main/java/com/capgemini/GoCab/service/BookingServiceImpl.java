package com.capgemini.GoCab.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		bookingEntity.setFare(calculateFare(booking));
		bookingDao.save(bookingEntity);
		return "booking done successfully";
	}
	
	public int calculateFare(BookingDTO booking)
	{
		String source=booking.getSource();
		String destination=booking.getDestination();
		List<String> arraylist=new ArrayList<>();
		arraylist.add(source+destination);
		if(arraylist.get(0).equalsIgnoreCase("MajesticWhiteField"))
		{
			return 305;
		}
		else if(arraylist.get(0).equalsIgnoreCase("MajesticKoramangla"))
		{
			return 477;
		}
		else if(arraylist.get(0).equalsIgnoreCase("MajesticSilkBoard"))
		{
			return 289;
		}
		else if(arraylist.get(0).equalsIgnoreCase("KIAWhitefield"))
		{
			return 789;
		}
		else if(arraylist.get(0).equalsIgnoreCase("KIAKoramangla"))
		{
			return 789;
		}
		else if(arraylist.get(0).equalsIgnoreCase("KIASilkBoard"))
		{
			return 898;
		}
		else if(arraylist.get(0).equalsIgnoreCase("WonderlaWhiteField"))
		{
			return 745;
		}
		else if(arraylist.get(0).equalsIgnoreCase("WonderlaSilkboard"))
		{
			return 509;
		}
		else 
		{
			return 477;
		}	
		
		
	}

}
