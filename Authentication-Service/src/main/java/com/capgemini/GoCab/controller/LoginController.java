package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.capgemini.GoCab.dto.AuthResponse;
import com.capgemini.GoCab.dto.LoginRequest;
import com.capgemini.GoCab.dto.LoginUser;
import com.capgemini.GoCab.exception.CustomException;
import com.capgemini.GoCab.service.ILoginService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    
    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = iLoginService.login(loginRequest.getUsername(),loginRequest.getPassword());
        HttpHeaders headers = new HttpHeaders();
        List<String> headerlist = new ArrayList<>();
        List<String> exposeList = new ArrayList<>();
        headerlist.add("Content-Type");
        headerlist.add(" Accept");
        headerlist.add("X-Requested-With");
        headerlist.add("Authorization");
        headers.setAccessControlAllowHeaders(headerlist);
        exposeList.add("Authorization");
        headers.setAccessControlExposeHeaders(exposeList);
        headers.set("Authorization", token);
        return new ResponseEntity<AuthResponse>(new AuthResponse(token), headers, HttpStatus.CREATED);
    }
    
    @PostMapping(value="/create")
	public String saveUser(@RequestBody LoginUser user) throws CustomException, IOException {
		//System.out.println("hiii"+user);
		return iLoginService.createUser(user);
	}
    
    /**
    *
    * @param token
    * @return boolean.
    * if request reach here it means it is a valid token.
    */
   @PostMapping("/valid/token")
   @ResponseBody
   @Transactional
   public Boolean isValidToken (@RequestHeader(value="Authorization") String token) {
       return true;
   }


   @PostMapping("/signin/token")
   @CrossOrigin("*")
   @ResponseBody
   public ResponseEntity<AuthResponse> createNewToken (@RequestHeader(value="Authorization") String token) {
       String newToken = iLoginService.createNewToken(token);
       HttpHeaders headers = new HttpHeaders();
       List<String> headerList = new ArrayList<>();
       List<String> exposeList = new ArrayList<>();
       headerList.add("Content-Type");
       headerList.add(" Accept");
       headerList.add("X-Requested-With");
       headerList.add("Authorization");
       headers.setAccessControlAllowHeaders(headerList);
       exposeList.add("Authorization");
       headers.setAccessControlExposeHeaders(exposeList);
       headers.set("Authorization", newToken);
       return new ResponseEntity<AuthResponse>(new AuthResponse(newToken), headers, HttpStatus.CREATED);
   }
}