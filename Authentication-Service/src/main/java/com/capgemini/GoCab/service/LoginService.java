package com.capgemini.GoCab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.GoCab.dto.LoginUser;
//import com.aptigeeks.entity.Role;
import com.capgemini.GoCab.entity.User;
import com.capgemini.GoCab.exception.CustomException;
import com.capgemini.GoCab.repository.UserRepository;
import com.capgemini.GoCab.security.JwtTokenProvider;
import com.capgemini.GoCab.security.JwtTokenFilter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LoginService implements ILoginService
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private JwtTokenRepository jwtTokenRepository;

    @Override
    public String login(String username, String password) {
    	String token = null;
        try {
//        	System.out.println("hi");
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
//                    password));
//            System.out.println("Helllo");
            User user = userRepository.findByEmail(username);
            if (user == null) {
                throw new com.capgemini.GoCab.exception.CustomException("Invalid username or password.Hi", HttpStatus.UNAUTHORIZED);
            }
            if(passwordEncoder.matches(password,user.getPassword())) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            token =  jwtTokenProvider.createToken(username, user.getRole().stream()
                    .map((String role)-> "ROLE_"+role).filter(Objects::nonNull).collect(Collectors.toList()));
           
            }
            return token;
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

//    @Override
//    public LoginUser saveUser(LoginUser user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()) );
//        return userRepository.save(user);
//    }

//    @Override
//    public boolean logout(String token) {
//         jwtTokenRepository.delete(new JwtToken(token));
//         return true;
//    }

    @Override
    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        List<String>roleList = jwtTokenProvider.getRoleList(token);
        String newToken =  jwtTokenProvider.createToken(username,roleList);
        return newToken;
    }

	@Override
	public String createUser(LoginUser user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		User userEntity = new User();
		
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(encodedPassword);
		userEntity.setRole(user.getRole());
		
		userRepository.save(userEntity);
		
		return "User added";
	}
}