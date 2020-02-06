package com.capgemini.GoCab.dto;

public class Rider {

	private String name;
	private String phoneNumber;
	private String emailId;
	private String city;
	private String zipcode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Rider(String name, String phoneNumber, String emailId, String city, String zipcode) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.city = city;
		this.zipcode = zipcode;
	}
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
