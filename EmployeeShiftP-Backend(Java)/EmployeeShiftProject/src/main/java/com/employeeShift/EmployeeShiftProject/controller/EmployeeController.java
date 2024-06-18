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

import com.employeeShift.EmployeeShiftProject.dao.EmployeeServiceImpl;
import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.EmployeeResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl  employeeServiceImpl;
	

	//EmployeeResponse EmployeeResponse;

	@GetMapping("employeeShift/allEmployeeDetails")
	public EmployeeResponse getAllEmployeeDetails() {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		employeeResponse.setAllEmployee(employeeServiceImpl.getAllEmployees());
		
		return employeeResponse;
		//return employeeServiceImpl.getAllEmployees();
	}
	
	//This is using path variable 
	@GetMapping("employeeShift/getEmployeeById/{id}")
	public EmployeeResponse getEmployeeById(@PathVariable Long id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		Employee emp =employeeServiceImpl.getEmployeeById(id);
		System.out.println(emp);
		employeeResponse.setEmployee(emp);
		//return employeeServiceImpl.getEmployeeById(id);
		return employeeResponse;
	}
	
	
	//to be implemented
//	@GetMapping("employeeShift/getEmployeeByName/query")
//	public Employee getEmployeeByNameAndProject(@RequestParam String name,@RequestParam String project) {
//		
//		return employeeServiceImpl;
//	}
	
	

	@PostMapping("employeeShift/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		
	}
	
	@PutMapping("employeeShift/updateEmployeeDetails")
	public void updateEmployee(@RequestBody Employee emp) {
		employeeServiceImpl.updateEmployee(emp);
		
	}
	
	@DeleteMapping("employeeShift/deleteEmployee/{id}")
	public void deleteById(@PathVariable Long id) {
		employeeServiceImpl.deleteEmployee(id);
	}
	
}
