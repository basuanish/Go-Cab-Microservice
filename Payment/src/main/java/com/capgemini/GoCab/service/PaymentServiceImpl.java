package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.GoCab.dao.PaymentDAO;
import com.capgemini.GoCab.dto.Payment;
import com.capgemini.GoCab.entity.PaymentEntity;

public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDAO paymentDAO;
	

	@Override
	public String addPayment(Payment payment)
	{
		PaymentEntity pE= new PaymentEntity();
		
		
	}
}
