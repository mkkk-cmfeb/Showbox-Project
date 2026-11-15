package com.showbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.showbox.dto.LoginRequest;
import com.showbox.dto.RegistrationRequest;
import com.showbox.dto.RegistrationResponse;
import com.showbox.exception.EmailAlreadyExistsException;
import com.showbox.exception.InvalidCredentialsException;
import com.showbox.model.User;
import com.showbox.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userrepo;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userrepo,PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder=passwordEncoder;
		this.userrepo=userrepo;
		
	}
	
	public User saveUsers(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userrepo.save(user);
	}
	
	public Optional<User> byId(Long id) {
		
		     
		return userrepo.findById(id);
		 
	}
	
	public List<User> getAll(){
		
		return userrepo.findAll();
	}
	
	public void deleteAccount(Long id) {
		
		 userrepo.deleteById(id);
	}
	
	public long countAccounts() {
		
		return userrepo.count();
	}
	
	public Optional<User> getByMail(String email){
		
		return userrepo.findByEmail(email);
	}
	
    
	public User registerUser(User user) {
		
		if(getByMail(user.getEmail()).isPresent()) {
			
		      throw new EmailAlreadyExistsException("Email already registered");   
		}
		
		return saveUsers(user);	
	}
	
public RegistrationResponse registerUsers(RegistrationRequest regdto) {
	
	    User userobj=new User();
		
		userobj.setEmail(regdto.getEmail());
		userobj.setName(regdto.getName());
		userobj.setPhone(regdto.getPhone());
		userobj.setPassword(regdto.getPassword());
		userobj.setRole("USER");
		
		userobj= registerUser(userobj);	
		
		RegistrationResponse resp=new RegistrationResponse();
		
		resp.setEmail(userobj.getEmail());
		resp.setId(userobj.getId());
		resp.setName(userobj.getName());
		resp.setPhone(userobj.getPhone());
		resp.setRole(userobj.getRole());
		
		return resp;
	}

public RegistrationResponse login(LoginRequest login){
	
	User user=userrepo.findByEmail(login.getEmail()).orElseThrow(()->new InvalidCredentialsException("Invalid Email"));
	
	 RegistrationResponse resp=null;
		if(passwordEncoder.matches(login.getPassword(),user.getPassword())) {
			
		   resp=new RegistrationResponse();
		   resp.setEmail(user.getEmail());
		   resp.setName(user.getName());
		   resp.setPhone(user.getPhone());
		   resp.setRole(user.getRole());
		     
		}
		else {
			
             throw new InvalidCredentialsException("Wrong password");
		}
	return resp;
}

	
	
}