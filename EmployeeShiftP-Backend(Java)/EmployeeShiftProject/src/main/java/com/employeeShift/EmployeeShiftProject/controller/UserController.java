package com.employeeShift.EmployeeShiftProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.User;
import com.employeeShift.EmployeeShiftProject.service.UserServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("employeeShift/registerUser")
	public  ResponseEntity<User>registerUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userServiceImpl.registerUser(user);
		
		return ResponseEntity.created(null).build();
	}
	
	@PostMapping("employeeShift/getAllEmployeeOfOrganization/{allocatedBy}")
	public List<Employee>getAllEmployeeOfOrganization(@PathVariable String allocatedBy){
		return userServiceImpl.getAllEmployee(allocatedBy);

		

//	
//	@PostMapping("employeeShift/member-Login")
//	public
}
}
