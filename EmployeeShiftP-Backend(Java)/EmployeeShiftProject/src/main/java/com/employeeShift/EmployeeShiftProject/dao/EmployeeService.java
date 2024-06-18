package com.employeeShift.EmployeeShiftProject.dao;

import java.util.List;

import com.employeeShift.EmployeeShiftProject.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	void updateEmployee(Employee employee);
	void deleteEmployee(Long id); 
	

}
