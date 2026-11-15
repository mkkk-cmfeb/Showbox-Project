package com.showbox.dto;

public class RegistrationResponse {
	
	
	private Long id;
	private String name;
	private String phone;
	private String role;
	private String email;
	
	
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

public void setPhone(String phone) {
	
	this.phone=phone;
}

public String getPhone() {
	
	return phone;
}

public void setId(Long id) {
    this.id = id;
}

public Long getId() {
	
	return id;
}

public void setRole(String role) {
	
	this.role=role;
}

public String getRole() {
	
	return role;
}


}
