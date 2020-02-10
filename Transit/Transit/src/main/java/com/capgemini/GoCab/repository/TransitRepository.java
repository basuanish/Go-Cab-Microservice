package com.capgemini.GoCab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.model.TransitModel;

@Repository
public interface TransitRepository extends JpaRepository<TransitModel, Long>{

	List <TransitModel> findByCabTypeAndStatus (String cab_type ,String status);
	//List <TransitModel> findFirst1ByCabTypeAndStatus 	(String cab_type ,String status) 
}
