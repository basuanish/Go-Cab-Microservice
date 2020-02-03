package com.capgemini.GoCab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "driver")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DriverEntity {

		@Column(name = "Name")
		private String name;

		@Column(name = "Age")
		private int age;
		
		@Id
		@Column(name = "phone_number")
		private int phoneNumber;

		@Column(name = "car_type")
		private String carType;

		@Column(name = "Car_Number")
		private String carNumber;
}
