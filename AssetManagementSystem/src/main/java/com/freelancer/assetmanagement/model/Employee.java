package com.freelancer.assetmanagement.model;

import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//
//@ToString
@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3923091466130903845L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
<<<<<<< HEAD
	private String employeeImage;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
//	@JsonIgnore
	private String password;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private String mobileNumber;
	private String designation;
	private Boolean active;
	
//	@Enumerated(EnumType.STRING)
	private List<String> role;
	
	@ManyToOne
	@JoinColumn
//	@JsonManagedReference
	private Organization organization;
	
	@OneToMany(mappedBy = "employee")
<<<<<<< HEAD
//	@JsonBackReference
	@JsonIgnore
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	private List<Asset> assets;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

<<<<<<< HEAD
	

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}
	
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", password=" + password + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", designation=" + designation
<<<<<<< HEAD
				+ ", active=" + active + ", role=" + role +  "]";
	}
	
=======
				+ ", active=" + active + ", role=" + role + ", assets=" + assets + "]";
	}
	
	
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
}
