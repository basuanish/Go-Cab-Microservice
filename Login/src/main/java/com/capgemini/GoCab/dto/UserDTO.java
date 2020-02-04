package com.capgemini.GoCab.dto;


public class UserDTO {

	private String phoneNumber;
	private String email;
	private String password;
	private String secretKey;

	public UserDTO() {

	}
	
	

	public UserDTO(String phoneNumber, String email, String password, String secretKey) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.secretKey = secretKey;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
