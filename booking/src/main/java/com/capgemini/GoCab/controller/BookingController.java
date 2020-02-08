package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.dao.BookingDao;
import com.capgemini.GoCab.dto.BookingDTO;
import com.capgemini.GoCab.entity.Booking;
import com.capgemini.GoCab.service.BookingService;

//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path ="/booking")
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(path="/add")
	public String bookCab(@RequestBody BookingDTO booking) {
		
		//return "cdvj";
		return bookingService.addBooking(booking);
	}

}