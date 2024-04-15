package com.freelancer.assetmanagement.model;

import org.springframework.stereotype.Component;

import com.freelancer.assetmanagement.dto.EmployeeDto;

@Component
public class GeneratedToken {

	private String token;
	private Organization organization;
    private EmployeeDto employeeDto;
	
	
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
 
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

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
		return "GeneratedToken [token=" + token + ", organization=" + organization + "]";
	}

	
}

