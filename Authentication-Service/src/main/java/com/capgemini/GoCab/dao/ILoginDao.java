package com.capgemini.GoCab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.entity.LoginEntity;

@Repository
public interface ILoginDao extends JpaRepository<LoginEntity, String> {

}
