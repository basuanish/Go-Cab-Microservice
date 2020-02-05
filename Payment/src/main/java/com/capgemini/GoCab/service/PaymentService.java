package com.capgemini.GoCab.service;

import java.util.List;

import com.capgemini.GoCab.entity.Payment;

public interface PaymentService {

	public List<Payment> viewPayments();

	public Payment getPaymentDetails(String paymentId);

	public Payment createPayment(Payment payment, String bookingId);

}