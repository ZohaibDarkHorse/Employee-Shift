package com.employeeShift.EmployeeShiftProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeShift.EmployeeShiftProject.dao.UserServiceImpl;
import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.User;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("employeeShift/registerUser")
	public  ResponseEntity<User>registerUser(@RequestBody User user) {
		userServiceImpl.registerUser(user);
		
		return ResponseEntity.created(null).build();
	}
	
	@PostMapping("employeeShift/getAllEmployeeOfOrganization")
	public List<Employee>getAllEmployeeOfOrganization(@RequestBody User user){
		return userServiceImpl.getAllEmployee(user);
		
		//return null;
	}
//	
//	@PostMapping("employeeShift/member-Login")
//	public
}
