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
		private String phoneNumber;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "car_type")
		private String carType;

		@Column(name = "Car_Number")
		private String carNumber;

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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		

}
	