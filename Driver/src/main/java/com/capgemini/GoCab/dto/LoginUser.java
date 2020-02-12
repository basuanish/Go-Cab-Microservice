package com.capgemini.GoCab.dto;

import java.util.Set;

public class LoginUser {

	private String email;
	private String password;
	private String name;
	 private Set<String> role;
	public LoginUser() {
	
	}
	public LoginUser(String email, String password, String name, Set<String> role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.role = role;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
	}
	 
	 
}
