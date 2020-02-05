package com.capgemini.GoCab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="payment")
@Component
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Payment {
	
	@Id
	@Column(name="payment_id")
	private String paymentId;
	
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	@Column(name="price")
	private int price;

	public Payment() {
	
	}

	public Payment(String paymentId, String bookingId, Date paymentDate, int price) {
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.paymentDate = paymentDate;
		this.price = price;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
