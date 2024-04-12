package com.freelancer.assetmanagement.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.assetmanagement.dto.EmployeeData;
import com.freelancer.assetmanagement.dto.EmployeeDto;
import com.freelancer.assetmanagement.model.AuthRequest;
import com.freelancer.assetmanagement.model.Employee;
import com.freelancer.assetmanagement.model.GeneratedToken;
import com.freelancer.assetmanagement.service.EmployeeService;
import com.freelancer.assetmanagement.service.JwtService;
import com.freelancer.assetmanagement.util.ResponseStructure;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "Content-type")

//@Tag(
//        name = "",
//        description = ""
//)
public class EmployeeController {

	Logger log=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private GeneratedToken generatedToken;

//	 @Operation(
//	            summary = "",
//	            description = ""
//	    )
//	    @ApiResponses({
//	            @ApiResponse(
//	                    responseCode = "201",
//	                    description = "HTTP Status CREATED"
//	            ),
//	            @ApiResponse(
//	                    responseCode = "500",
//	                    description = "HTTP Status Internal Server Error",
//	                    content = @Content(
//	                            schema = @Schema(implementation = ErrorResponseDto.class)
//	                    )
//	            )
//	    }
//	    ) 
	@PostMapping("/postEmployee")
	public ResponseEntity<ResponseStructure<EmployeeData>> saveEmployee(@RequestBody EmployeeData employeeData) {
		log.info("EmployeeData->"+employeeData);
		ResponseStructure<EmployeeData> response = new ResponseStructure<>();
//		EmployeeData data=EmployeeData.builder().build();
//		data.setEmployeeId(employeeData.getEmployeeId());
		
		EmployeeData savedEmployee = employeeService.saveEmployee(employeeData);

		log.info("Logging-> "+savedEmployee);
		if (Objects.nonNull(savedEmployee)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Employee saved successfully");
			response.setData(savedEmployee);
			ResponseEntity<ResponseStructure<EmployeeData>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Employee not saved");
			response.setData(null);
			ResponseEntity<ResponseStructure<EmployeeData>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<ResponseStructure<List<EmployeeDto>>> getAllEmployees(){
		ResponseStructure<List<EmployeeDto>> response = new ResponseStructure<>();
		List<EmployeeDto> fetchedEmployees = employeeService.fetchAllEmployees();

		log.info("Logging fetchedEmployees-> "+fetchedEmployees);
		if (Objects.nonNull(fetchedEmployees)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("All Employees fetched successfully");
			response.setData(fetchedEmployees);
			ResponseEntity<ResponseStructure<List<EmployeeDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Employees not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<List<EmployeeDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	
	@GetMapping("/getEmployeeById")
	public ResponseEntity<ResponseStructure<EmployeeDto>> getEmployeeById(@RequestParam String employeeId) {
		ResponseStructure<EmployeeDto> response = new ResponseStructure<>();
		EmployeeDto fetchedEmployee = employeeService.findEmployeeById(employeeId);

		log.info("Logging fetchedEmployee-> "+fetchedEmployee);
		if (Objects.nonNull(fetchedEmployee)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Employee fetched successfully");
			response.setData(fetchedEmployee);
			ResponseEntity<ResponseStructure<EmployeeDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Employee not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<EmployeeDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<EmployeeData>> updateEmployeeByEmployeeId(@RequestBody EmployeeData employeeData) {
		ResponseStructure<EmployeeData> response = new ResponseStructure<>();
		EmployeeData updateEmployee = employeeService.updateEmployeeByEmployeeId(employeeData);

		log.info("Logging updateEmployee-> "+updateEmployee);
		if (Objects.nonNull(updateEmployee)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Employee updated successfully");
			response.setData(updateEmployee);
			ResponseEntity<ResponseStructure<EmployeeData>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Employee not updated");
			response.setData(null);
			ResponseEntity<ResponseStructure<EmployeeData>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByEmployeeId(@RequestParam String employeeId) {
		ResponseStructure<String> response = new ResponseStructure<>();
		String deleteMessage = employeeService.deleteEmployeeByEmployeeId(employeeId);

		log.info("Logging delete Message-> "+deleteMessage);
		if (Objects.nonNull(deleteMessage)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Employee deleted successfully");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Employee not deleted");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<ResponseStructure<GeneratedToken>> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		log.info("authenticate username ->"+authRequest.getUserName()+" password->"+authRequest.getPassword());
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		log.info("authenticate ->"+authenticate);
		ResponseStructure<GeneratedToken> response=new ResponseStructure<>();
		if(authenticate.isAuthenticated()) {
			
			generatedToken.setToken(jwtService.generateToken(authRequest.getUserName()));
//			generatedToken.setOrganizationId(authRequest.getOrganizationId()); //org is setted in employeeServiceImp class
			log.info("orgnaization id in generated token->"+generatedToken.getOrganization());
				response.setStatus(HttpStatus.OK.value());
			response.setData(generatedToken);
			response.setMessage("Token Generated Successfully");
			ResponseEntity<ResponseStructure<GeneratedToken>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			throw new UsernameNotFoundException("Invalid User Name");
		}
	}
	
	@DeleteMapping("/deleteByEmployeeId")
	public Integer deleteByEmployeeId(@RequestParam String employeeId) {
		return employeeService.deleteByEmployeeId(employeeId);
		 
	}
}
