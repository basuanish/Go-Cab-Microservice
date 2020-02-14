package com.capgemini.GoCab.dto;

public class BookingDTO {

	private String bookingId;
	private String source;
	private String destination;
	private String cabType;
	private int fare;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
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
	
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDTO(String bookingId, String source, String destination, String cabType, int fare) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		//this.cabType = cabType;
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "BookingDTO [source=" + source + ", destination=" + destination + ", cabType=" + ", fare="
				+ fare + "]";
	}
	
	
	
}
