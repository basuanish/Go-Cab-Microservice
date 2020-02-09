package com.capgemini.GoCab.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "cabs") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})   //Serialization issue
public class TransitModel {
	
	@Id
	private String number;
	private String cabType;
	private String name;
	private String status ;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
