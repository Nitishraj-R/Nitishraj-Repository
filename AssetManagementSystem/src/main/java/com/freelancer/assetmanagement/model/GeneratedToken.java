package com.freelancer.assetmanagement.model;

import org.springframework.stereotype.Component;

import com.freelancer.assetmanagement.dto.EmployeeDto;
<<<<<<< HEAD
import com.freelancer.assetmanagement.dto.OrganizationData;
import com.freelancer.assetmanagement.dto.OrganizationDto;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

@Component
public class GeneratedToken {

	private String token;
<<<<<<< HEAD
//	private OrganizationDto organizationDto;
	private EmployeeDto employeeDto;
=======
	private Organization organization;
    private EmployeeDto employeeDto;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	
	
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
<<<<<<< HEAD

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

//	public OrganizationDto getOrganizationDto() {
//		return organizationDto;
//	}
//
//	public void setOrganizationDto(OrganizationDto organizationDto) {
//		this.organizationDto = organizationDto;
//	}
=======
 
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

	public GeneratedToken() {
		super();
	}

	public GeneratedToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "GeneratedToken [token=" + token + "]";
=======
		return "GeneratedToken [token=" + token + ", organization=" + organization + "]";
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	}

	
}

