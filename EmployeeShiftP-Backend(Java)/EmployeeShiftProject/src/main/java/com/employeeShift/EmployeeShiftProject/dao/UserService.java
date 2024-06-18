package com.employeeShift.EmployeeShiftProject.dao;

import java.util.List;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.User;

public interface UserService {

	void registerUser(User user);
	
	List<Employee> getAllEmployee(User user);

}
