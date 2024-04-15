package com.freelancer.assetmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.assetmanagement.config.UserInfoUserDetails;
import com.freelancer.assetmanagement.controller.EmployeeController;
import com.freelancer.assetmanagement.dto.EmployeeData;
import com.freelancer.assetmanagement.dto.EmployeeDto;
import com.freelancer.assetmanagement.dto.OrganizationDto;
import com.freelancer.assetmanagement.model.AuthRequest;
import com.freelancer.assetmanagement.model.Employee;
import com.freelancer.assetmanagement.model.GeneratedToken;
import com.freelancer.assetmanagement.repository.EmployeeRepository;
import com.freelancer.assetmanagement.repository.OrganizationRepository;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService, UserDetailsService {

	public static final Boolean active = true;
	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthRequest authRequest;

	@Autowired
	private GeneratedToken generatedToken;

	@Override
	public EmployeeData saveEmployee(EmployeeData employeeData) {
		employeeData.setPassword(encoder.encode(employeeData.getPassword()));
//		if(employee.getOrganization()!=null) {
//			organizationRepository.save(employee.getOrganization());
//		}
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeData, employee);
		employee.setActive(active);

		Employee savedEmployee = employeeRepository.save(employee);
		if (Objects.nonNull(savedEmployee)) {
			employeeData.setId(savedEmployee.getId());
			employeeData.setCreatedAt(savedEmployee.getCreatedAt());
			employeeData.setCreatedBy(savedEmployee.getCreatedBy());
			employeeData.setModifiedAt(savedEmployee.getModifiedAt());
			employeeData.setModifiedBy(savedEmployee.getModifiedBy());
			return employeeData;
		} else {
			return null;
		}
	}

	@Override
	public List<EmployeeDto> fetchAllEmployees() {
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();

//		List<Employee> employees = employeeRepository.findAll();
		List<Employee> employees = employeeRepository.findByActive(active);
		for (Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeDto);
			employeeDtos.add(employeeDto);

		}
		return employeeDtos;
	}

	@Override
	public EmployeeDto findEmployeeById(String employeeId) {
		EmployeeDto employeeDto = new EmployeeDto();
		Employee employee = employeeRepository.findByEmployeeIdAndActive(employeeId, active);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeData updateEmployeeByEmployeeId(EmployeeData employeeData) {
		Employee findByEmployeeId = employeeRepository.findByEmployeeIdAndActive(employeeData.getEmployeeId(), active);
		if (findByEmployeeId != null) {
			employeeData.setPassword(encoder.encode(employeeData.getPassword()));
			employeeData.setEmployeeId(findByEmployeeId.getEmployeeId());
			employeeData.setCreatedAt(findByEmployeeId.getCreatedAt());
			employeeData.setCreatedBy(findByEmployeeId.getCreatedBy());
			BeanUtils.copyProperties(employeeData, findByEmployeeId);

			Employee updatedEmployee = employeeRepository.save(findByEmployeeId);
			employeeData.setCreatedAt(updatedEmployee.getCreatedAt());
			employeeData.setCreatedBy(updatedEmployee.getCreatedBy());
			employeeData.setModifiedAt(updatedEmployee.getModifiedAt());
			employeeData.setModifiedBy(updatedEmployee.getModifiedBy());
			return employeeData;
		} else {
			log.info("Employee not found so update is not possible");
			return null;
		}
	}

	@Override
	public String deleteEmployeeByEmployeeId(String employeeId) {
		Employee findByEmployeeId = employeeRepository.findByEmployeeIdAndActive(employeeId, active);
		if (findByEmployeeId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByEmployeeId.setActive(!active);
			employeeRepository.save(findByEmployeeId);
			return "deleted Successfully";
		} else {
			log.info("Employee not found so delete is not possible");
			return "Employee not found to delete";
		}
	}

	public Integer deleteByEmployeeId(String employeeId) {
		Employee findByEmployeeId = employeeRepository.findByEmployeeIdAndActive(employeeId, active);

		if (findByEmployeeId != null) {
//			Optional<Integer> deleteByEmployeeId = employeeRepository.deleteByEmployeeIdAndActive(employeeId,active);
//			if(deleteByEmployeeId.isPresent()) {
//			return deleteByEmployeeId.get();
//			}
//			else {
//				return Integer.valueOf(0);
//			}
			findByEmployeeId.setActive(!active);
			employeeRepository.save(findByEmployeeId);
			return 1;
		} else {
			log.info("Employee not found so delete is not possible");
			return Integer.valueOf(-1);
		}

	}

	public EmployeeDto findEmployeeByEmailId(String emailId) {
		EmployeeDto employeeDto = new EmployeeDto();
		Optional<Employee> findByEmailIdAndActive = employeeRepository.findByEmailIdAndActive(emailId, active);
		if (findByEmailIdAndActive.isPresent()) {
			BeanUtils.copyProperties(findByEmailIdAndActive.get(), employeeDto);
			return employeeDto;
		}
		else {
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
//		String firstName = username.split(" ")[0];
//		String lastName = username.split(" ")[1];
//		System.out.println("firstName=" + firstName + ", lastName=" + lastName);
		Optional<Employee> userInfo = employeeRepository.findByEmailIdAndActive(emailId, active);
		System.out.println("Employee->" + userInfo.get());
		if (userInfo.isPresent()) {
			OrganizationDto dto=new OrganizationDto();
			BeanUtils.copyProperties(userInfo.get().getOrganization(), dto);
			authRequest.setOrganizationDto(dto);
//			generatedToken.setOrganizationDto(authRequest.getOrganizationDto());
			log.info("orgnaization id in EmployeeServiceImp->" + authRequest.getOrganizationDto());

		}
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + emailId));
	}

}
