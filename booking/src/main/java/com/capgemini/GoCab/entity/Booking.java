package com.capgemini.GoCab.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="booking")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Booking {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String bookingId;
	private String source;
	private String destination;
	private String cabType;
	private int fare;
	private String name;
	
	public Booking() {
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

}