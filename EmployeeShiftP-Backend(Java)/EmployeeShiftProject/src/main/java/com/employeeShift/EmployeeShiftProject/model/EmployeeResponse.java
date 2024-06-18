package com.employeeShift.EmployeeShiftProject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
@JsonProperty("GetEmployee")
private Employee employee;

@JsonProperty("GetAllEmployee")
private List<Employee> allEmployee;

public EmployeeResponse() {
	
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public List<Employee> getAllEmployee() {
	return allEmployee;
}

public void setAllEmployee(List<Employee> allEmployee) {
	this.allEmployee = allEmployee;
}
}
