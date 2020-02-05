package com.capgemini.GoCab.dto;

public class Rider {

	private String name;
	private String phoneNumber;
	private String emailId;
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
	
	public Rider(String name, String phoneNumber, String emailId, String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
