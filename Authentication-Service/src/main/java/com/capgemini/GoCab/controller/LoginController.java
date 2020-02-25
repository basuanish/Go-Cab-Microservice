package com.capgemini.GoCab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.capgemini.GoCab.dto.AuthResponse;
import com.capgemini.GoCab.dto.LoginRequest;
import com.capgemini.GoCab.dto.LoginUser;
import com.capgemini.GoCab.exception.CustomException;
import com.capgemini.GoCab.service.ILoginService;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path="/signin",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String login(@RequestBody LoginRequest loginRequest) {
    	JsonObject dataResponse = new JsonObject();
    	try {
        String token = iLoginService.login(loginRequest.getUsername(),loginRequest.getPassword());
//        HttpHeaders headers = new HttpHeaders();
//        List<String> headerlist = new ArrayList<>();
//        List<String> exposeList = new ArrayList<>();
//        headerlist.add("Content-Type");
//        headerlist.add(" Accept");
//        headerlist.add("X-Requested-With");
//        headerlist.add("Authorization");
//        headers.setAccessControlAllowHeaders(headerlist);
//        exposeList.add("Authorization");
//        headers.setAccessControlExposeHeaders(exposeList);
//        headers.set("Authorization", token);
        //AuthResponse success =new AuthResponse("Logged in"); 
        dataResponse.addProperty("success", true);
		dataResponse.addProperty("message", "Login successful");
		dataResponse.addProperty("accessToken", token);
    	}
    	catch(CustomException e) {
    		dataResponse.addProperty("success", false);
			dataResponse.addProperty("message", e.getMessage());
			dataResponse.addProperty("accessToken", false);;
    	//return new ResponseEntity<AuthResponse>(new AuthResponse(e.getMessage()),HttpStatus.UNAUTHORIZED);
//    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//    				.body(e.getMessage());
    	}
    	return dataResponse.toString();
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