package com.capgemini.GoCab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;
import com.capgemini.GoCab.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path ="/booking")
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
			System.out.println("inside controller");
			System.out.println(booking);
			bookingNew =  bookingService.generateFare(booking);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return bookingNew;
		
	}
	
	
	@GetMapping(value="/getBookings")
	
		public List<Booking> getAllBookings() {
		
		return bookingService.getBookings();
		
		}

   }