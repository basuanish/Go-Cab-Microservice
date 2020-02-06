package com.capgemini.GoCab.dto;

public class Rider {

	private String name;
	private String phoneNumber;
	private String email;
	private String city;
	private String zipcode;
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rider(String name, String phoneNumber, String email, String city, String zipcode,String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.zipcode = zipcode;
		this.password = password;
	}
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rider [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", city=" + city
				+ ", zipcode=" + zipcode + ", password=" + password+"]";
	}
	
	
}
