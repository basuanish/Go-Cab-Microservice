package com.capgemini.GoCab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.constants.PaymentConstants;
import com.capgemini.GoCab.entity.Payment;
import com.capgemini.GoCab.service.PaymentService;

@RestController
@RequestMapping(PaymentConstants.controllerMapping)
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping(PaymentConstants.viewPaymentsMapping)
	public List<Payment> viewPayments(){
		return paymentService.viewPayments();
	}
	
	@GetMapping
	@RequestMapping(PaymentConstants.getPaymentDetailsMapping)
	public Payment getPaymentDetails(@PathVariable String paymentId) {
		return paymentService.getPaymentDetails(paymentId);
	}
	
	
	@PostMapping(PaymentConstants.createPaymentMapping)
	public Payment createPayment(@RequestBody Payment payment, @PathVariable String bookingId) {	
		return paymentService.createPayment(payment,bookingId);
	}
}

