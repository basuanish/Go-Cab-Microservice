package com.capgemini.GoCab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="booking")
@Component
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Booking {
	
	@Id
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="bus_number")
	private String busNumber;
	
	@Column(name="total_price")
	private int totalPrice;
	
public Booking() {
		
	}

public Booking(String bookingId, String busNumber, int totalPrice) {
	super();
	this.bookingId = bookingId;
	this.busNumber = busNumber;
	this.totalPrice = totalPrice;
}

public String getBookingId() {
	return bookingId;
}

public void setBookingId(String bookingId) {
	this.bookingId = bookingId;
}

public String getBusNumber() {
	return busNumber;
}

public void setBusNumber(String busNumber) {
	this.busNumber = busNumber;
}

public int getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}

}