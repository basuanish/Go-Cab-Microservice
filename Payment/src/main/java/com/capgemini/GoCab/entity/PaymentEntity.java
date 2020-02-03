package com.capgemini.GoCab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "payment")

public class PaymentEntity {

	@Id
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "fare")
	private int fare;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
