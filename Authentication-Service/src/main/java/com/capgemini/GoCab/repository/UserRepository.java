package com.capgemini.GoCab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}