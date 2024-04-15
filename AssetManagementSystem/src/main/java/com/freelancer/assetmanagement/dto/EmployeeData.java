package com.freelancer.assetmanagement.dto;

import java.util.Date;
import java.util.List;

import com.freelancer.assetmanagement.model.BaseModel;
import com.freelancer.assetmanagement.model.Organization;

import lombok.Builder;
import lombok.Data;
@Data
//@Builder
public class EmployeeData extends BaseModel {

	/**@
	 * 
	 */
	private static final long serialVersionUID = 1187140875575028964L;
	private long id;
<<<<<<< HEAD
	private String employeeImage;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private String mobileNumber;
	private String designation;
	private Boolean active;
	
<<<<<<< HEAD


	//	@Enumerated(EnumType.STRING)
	private List<String> role;
	
	private OrganizationData organizationData;
	
//	private List<Asset> assets;
	
	public Boolean getActive() {
=======
public Boolean getActive() {
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

<<<<<<< HEAD
=======
	//	@Enumerated(EnumType.STRING)
	private List<String> role;
	
	private Organization organization;
	
//	private List<Asset> assets;

>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	
<<<<<<< HEAD
	public OrganizationData getOrganizationData() {
		return organizationData;
	}

	public void setOrganizationData(OrganizationData organizationData) {
		this.organizationData = organizationData;
=======
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", password=" + password + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", designation=" + designation
				+ ", active=" + active + ", role=" + role + "]";
	}

	
}
