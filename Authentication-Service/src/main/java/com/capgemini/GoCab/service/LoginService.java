package com.capgemini.GoCab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dao.ILoginDao;
import com.capgemini.GoCab.dto.Credential;
import com.capgemini.GoCab.entity.LoginEntity;

@Service
public class LoginService {
	
	@Autowired
	private ILoginDao ldao;
	
	//private BCryptPasswordEncoder passwordEncoder;
	
	public Credential getUserDetails(String userName) {
		Optional<LoginEntity> le =  ldao.findById(userName);
		if(!le.isEmpty()) {
			Credential cd = new Credential(le.get().getUsername(),le.get().getPassword());
			return cd;
		}
		else
			return null;
	}
}
