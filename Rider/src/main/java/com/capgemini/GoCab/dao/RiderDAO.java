package com.capgemini.GoCab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.GoCab.entity.RiderEntity;

public interface RiderDAO extends JpaRepository<RiderEntity,Integer>
{

}
