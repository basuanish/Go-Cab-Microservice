package com.capgemini.GoCab.dto;

public class Booking {

	private String bookingId;
	private String source;
	private String destination;
	private String cabType;
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
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public Booking(String bookingId, String source, String destination, String cabType) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.cabType = cabType;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
