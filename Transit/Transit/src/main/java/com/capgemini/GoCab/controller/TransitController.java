package com.capgemini.GoCab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.GoCab.constants.TransitConstants;
import com.capgemini.GoCab.model.TransitModel;
import com.capgemini.GoCab.repository.TransitRepository;

@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(path="/transit")
@RestController
public class TransitController {
	
	
	@Autowired
	private TransitRepository transitRepository ;
	
	@GetMapping(path="/search/{cabType}")
	List <TransitModel>findByQuery(@PathVariable String cabType)
	{
		System.out.println(cabType);
		return transitRepository.findByCabTypeAndStatus(cabType, TransitConstants.Status) ;
	}
			
}
