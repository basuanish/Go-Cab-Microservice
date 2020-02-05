package com.capgemini.GoCab.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserService implements UserDetailsService {

	@Autowired
	private LoginService service;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		String username = service.getUserDetails(arg0).getUsername();
		String password = service.getUserDetails(arg0).getPassword();
		return new User(username, password, new ArrayList<>());
//		return new User("foo", "foo", new ArrayList<>());
	}

}
