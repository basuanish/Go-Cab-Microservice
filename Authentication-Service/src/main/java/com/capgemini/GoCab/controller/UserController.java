package com.capgemini.GoCab.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.GoCab.dto.AuthenticationRequest;
import com.capgemini.GoCab.dto.AuthenticationResponse;
import com.capgemini.GoCab.dto.User;
//import com.capgemini.GoCab.entity.ImageEntity;
//import com.capgemini.GoCab.entity.UserEntity;
//import com.capgemini.GoCab.exception.ImageCouldNotBeSavedException;
import com.capgemini.GoCab.exception.UserNotFoundException;
import com.capgemini.GoCab.exception.UserNotSavedException;
import com.capgemini.GoCab.security.JwtUtil;
//import com.capgemini.GoCab.service.ImageService;
import com.capgemini.GoCab.service.JwtUserService;
import com.capgemini.GoCab.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//@Autowired ImageService iService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private JwtUserService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	
	@PostMapping(value="/create")
	public String saveUser(@RequestBody User user) throws UserNotSavedException, IOException {
		//System.out.println("hiii"+user);
		return service.createUser(user);
	}
	
//	@PostMapping(value="/uploadImage")
//	public boolean uploadImage(@RequestBody MultipartFile imageFile) throws ImageCouldNotBeSavedException, IOException {
//		System.out.println(imageFile);
//		if(imageFile==null)
//			throw new ImageCouldNotBeSavedException("Image is not received properly");
//		return iService.saveImage(imageFile);
//	}
//	
//	@GetMapping(value="retrieveImage/{imageName}")
//	public ImageEntity retrieveImage(@PathVariable("imageName") String imageName) throws ImageCouldNotFoundException {
//		return iService.getImage(imageName);
//	}
//	
//	
//	
//	@GetMapping(value="/list",produces = "application/json")
//	public List<UserEntity> getAll() throws UserNotFoundException{
//		return service.getAllUsers();
//	}
//
//	@DeleteMapping(value="/remove/{userId}")
//	public boolean delete(@PathVariable int userId) throws UserNotFoundException {
//		return service.deleteUser(userId);
//	}
//	
//	@PutMapping(value="/update")
//	public boolean updateUser(@RequestBody UserEntity user) throws UserNotSavedException{
//		return service.updateUser(user);
//	}
//	
//	@GetMapping(value="/me")
//	public UserEntity getUserInfo(@Param("username") String username) throws UserNotFoundException {
//		return service.getInfo(username);
//	}
	
	
}