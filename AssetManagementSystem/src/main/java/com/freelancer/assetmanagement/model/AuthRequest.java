package com.freelancer.assetmanagement.model;

import org.springframework.stereotype.Component;

<<<<<<< HEAD
import com.freelancer.assetmanagement.dto.OrganizationData;
import com.freelancer.assetmanagement.dto.OrganizationDto;

=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
@Component
public class AuthRequest {

	private String emailId;
	private String password;
<<<<<<< HEAD
	private OrganizationDto organizationDto;
=======
	private Organization organization;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	
	
	public AuthRequest() {
		super();
	}
<<<<<<< HEAD
	public AuthRequest(String emailId, String password, OrganizationDto organizationDto) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.organizationDto = organizationDto;
=======
	public AuthRequest(String emailId, String password, Organization organization) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.organization = organization;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
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


<<<<<<< HEAD
	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}


	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
=======
	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	}


	@Override
	public String toString() {
<<<<<<< HEAD
		return "AuthRequest [emailId=" + emailId + ", password=" + password + ", organizationDto=" + organizationDto
=======
		return "AuthRequest [emailId=" + emailId + ", password=" + password + ", organization=" + organization
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
				+ "]";
	}


	
}

