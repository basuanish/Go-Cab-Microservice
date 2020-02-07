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

@RestController
@RequestMapping(Constants.controllerMapping)
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	Booking booking;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(Constants.createBookingMapping)
	public String create(@RequestBody BookingInformation bookingInformation) {
		JsonObject dataResponse = new JsonObject();
		try {
			System.out.println("inside controller");
			booking = bookingService.createBooking(bookingInformation);
			dataResponse.addProperty("success", true);
			dataResponse.addProperty("message", "Booking Created Successfully");
			dataResponse.addProperty("bookingId", booking.getBookingId().toString());
			dataResponse.addProperty("price", booking.getTotalPrice());
		} catch (BookingException e) {
			System.out.println(e.getMessage());
			dataResponse.addProperty("success", false);
			dataResponse.addProperty("message", e.getMessage());
		}
		return dataResponse.toString();
	}
}