package com.capgemini.GoCab.service;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.BookingDTO;
@Service
public interface BookingService {

	public String addBooking(BookingDTO booking);
}
