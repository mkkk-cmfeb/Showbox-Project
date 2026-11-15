package com.showbox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.showbox.dto.LoginRequest;
import com.showbox.dto.RegistrationRequest;
import com.showbox.dto.RegistrationResponse;
import com.showbox.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController{
	
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		
		this.userservice=userservice;
	}
	
	@PostMapping("/register")
	public RegistrationResponse register(@Valid @RequestBody RegistrationRequest req) {
		
		
		return userservice.registerUsers(req);
	}
	
	@PostMapping("/login")
	public RegistrationResponse loginController(@Valid @RequestBody LoginRequest log) {
		
		
		return userservice.login(log);
	}
	
}