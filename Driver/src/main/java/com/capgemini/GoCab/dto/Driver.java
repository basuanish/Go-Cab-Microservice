package com.capgemini.GoCab.dto;

public class Driver {

	private String name;
	private int age;
	private int phoneNumber;
	private String carType;
	private String carNumber;
	
	
	public Driver() {
		
	}


	public Driver(String name, int age, int phoneNumber, String carType, String carNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.carType = carType;
		this.carNumber = carNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public String getCarNumber() {
		return carNumber;
	}


	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	
	
}
