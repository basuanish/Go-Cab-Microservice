package com.capgemini.GoCab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.entity.DriverEntity;

@Repository
public interface DriverDAO extends JpaRepository<DriverEntity,Integer>{
	

}
