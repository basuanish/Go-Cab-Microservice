package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.entity.Booking;
import com.capgemini.GoCab.exceptions.BookingException;
import com.capgemini.GoCab.service.BookingService;
import com.capgemini.GoCab.constants.Constants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="book")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	Booking booking;


	
}