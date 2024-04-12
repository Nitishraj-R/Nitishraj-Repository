package com.freelancer.assetmanagement.model;

import org.springframework.stereotype.Component;

@Component
public class AuthRequest {

	private String userName;
	private String password;
	private Organization organization;
	
	
	public AuthRequest() {
		super();
	}
	public AuthRequest(String userName, String password, Organization organization) {
		super();
		this.userName = userName;
		this.password = password;
		this.organization = organization;
	}

	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	@Override
	public String toString() {
		return "AuthRequest [userName=" + userName + ", password=" + password + ", organization=" + organization
				+ "]";
	}


	
}

