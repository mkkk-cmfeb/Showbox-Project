package com.showbox.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistrationRequest{
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp="^[6-9][0-9]{9}$")
	private String phone;
	
	@NotBlank
	@Size(min=8)
	private String password;
	
	public void setEmail(String email) {
		
		this.email=email;
	}
	
	public String getEmail() {
		
		return email;
	}
	
public void setName(String name) {
		
		this.name=name;
	}

public String getName() {
	
	return name;
}

public void setPassword(String password) {
	
	this.password=password;
}

public String getPassword() {
	
	return password;
}

public void setPhone(String phone) {
	
	this.phone=phone;
}

public String getPhone() {
	
	return phone;
}

}