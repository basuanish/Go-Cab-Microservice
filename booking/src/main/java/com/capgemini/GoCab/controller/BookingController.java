package com.capgemini.GoCab.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;
import com.capgemini.GoCab.service.BookingService;


//@RequestMapping(path ="/booking")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(path="/add")
	public String bookCab(@RequestBody BookingDTO booking) {
		
		System.out.println(booking);
		return bookingService.addBooking(booking);
	}
	
	@PostMapping(path="/fare")
	public Booking getFare(@RequestBody Booking booking) {
		Booking bookingNew=new Booking();
		try {
			
			bookingNew =  bookingService.generateFare(booking);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return bookingNew;
		
	}
	
	
	@GetMapping(value="/getBookings")
	
		public List<Booking> getAllBookings() {
		System.out.println("Inside");
		return bookingService.getBookings();
		
		}
	
	@GetMapping(value="/getRiders")
	
		public Booking getRider()
		{
			return bookingService.getRider();
		}
	
	
		
	
	

   }