package com.freelancer.assetmanagement.model;

import org.springframework.stereotype.Component;

@Component
public class AuthRequest {

	private String emailId;
	private String password;
	private Organization organization;
	
	
	public AuthRequest() {
		super();
	}
	public AuthRequest(String emailId, String password, Organization organization) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.organization = organization;
	}

	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "AuthRequest [emailId=" + emailId + ", password=" + password + ", organization=" + organization
				+ "]";
	}


	
}

