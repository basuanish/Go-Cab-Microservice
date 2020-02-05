package com.capgemini.GoCab.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.GoCab.entity.Payment;
import com.capgemini.GoCab.exceptions.PaymentException;
import com.capgemini.GoCab.repository.PaymentRepository;

@Component
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private Payment payment;

	public List<Payment> viewPayments() {
		return paymentRepository.findAll();
	}

	public Payment getPaymentDetails(String paymentId) {
		try {
			payment = paymentRepository.getOne(paymentId);
		}catch(PaymentException e) {
			throw new PaymentException(e.getMessage());
		}
		return payment;
	}

	public Payment createPayment(Payment payment) {
		try {
			payment = paymentRepository.saveAndFlush(payment);
		}catch(PaymentException e) {
			throw new PaymentException(e.getMessage());
		}
		
		return payment;
	}

}
