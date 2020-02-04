package com.capgemini.GoCab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.GoCab.model.User;

public interface LoginRepository extends JpaRepository<User,String> {

}
