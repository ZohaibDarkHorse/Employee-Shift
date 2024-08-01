package com.employeeShift.EmployeeShiftProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeShift.EmployeeShiftProject.model.Employee;
//import com.employeeShift.EmployeeShiftProject.model.EmployeeResponse;
import com.employeeShift.EmployeeShiftProject.service.EmployeeServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl  employeeServiceImpl;
	

	

//	//EmployeeResponse EmployeeResponse;
//
//	@GetMapping("employeeShift/allEmployeeDetails")
//	public EmployeeResponse getAllEmployeeDetails() {
//		EmployeeResponse employeeResponse = new EmployeeResponse();
//		
//		employeeResponse.setAllEmployee(employeeServiceImpl.getAllEmployees());
//		
//		return employeeResponse;
//		//return employeeServiceImpl.getAllEmployees();
//	}
	

	
	//to be implemented
//	@GetMapping("employeeShift/getEmployeeByName/query")
//	public Employee getEmployeeByNameAndProject(@RequestParam String name,@RequestParam String project) {
//		
//		return employeeServiceImpl;
//	}
	
	


	
	@PutMapping("employeeShift/updateEmployeeDetails")
	public void updateEmployee(@RequestBody Employee emp) {
		employeeServiceImpl.updateEmployee(emp);
		
	}
	
	

	
	
}
