package com.capgemini.GoCab.service;

import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.Payment;
@Service

public interface PaymentService {

	public String addPayment(Payment payment);
	
}
