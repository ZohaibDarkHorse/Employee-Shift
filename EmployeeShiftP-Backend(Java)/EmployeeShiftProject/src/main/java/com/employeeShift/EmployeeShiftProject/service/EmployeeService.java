package com.employeeShift.EmployeeShiftProject.service;

import java.util.List;
import java.util.Optional;

import com.employeeShift.EmployeeShiftProject.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployeeById(Long id) throws Exception;
	void updateEmployee(Employee employee);
	void deleteEmployee(Long id); 
	

}
