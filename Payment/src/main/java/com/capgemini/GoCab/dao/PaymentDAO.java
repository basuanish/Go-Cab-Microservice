package com.capgemini.GoCab.dao;

import java.util.List;

import com.capgemini.GoCab.entity.Payment;

public interface PaymentDAO {

	public List<Payment> viewPayments();

	public Payment getPaymentDetails(String paymentId);

	public Payment createPayment(Payment payment);

}