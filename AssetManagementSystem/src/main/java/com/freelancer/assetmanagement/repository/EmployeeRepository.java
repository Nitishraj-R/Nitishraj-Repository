package com.freelancer.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.freelancer.assetmanagement.model.Asset;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
import com.freelancer.assetmanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByFirstNameAndLastNameAndActive(String firstName,String lastName,Boolean active);

	public Employee findByEmployeeIdAndActive(String employeeId,Boolean active);
	
	public Optional<Integer> deleteByEmployeeIdAndActive(String employeeId,Boolean active);

	public List<Employee> findByActive(Boolean active);

	public Optional<Employee> findByEmailIdAndActive(String emailId, Boolean active);
<<<<<<< HEAD
	

=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
}
