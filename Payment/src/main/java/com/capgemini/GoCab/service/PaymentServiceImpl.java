package com.capgemini.GoCab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dao.PaymentDAO;
import com.capgemini.GoCab.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO paymentDao;
	
	public List<Payment> viewPayments() {
		return paymentDao.viewPayments();
	}

	
	public Payment getPaymentDetails(String paymentId) {
		return paymentDao.getPaymentDetails(paymentId);
	}

	
	public Payment createPayment(Payment payment, String bookingId) {
		payment.setBookingId(bookingId);
		return paymentDao.createPayment(payment);
	}

}
