package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmployeeById {

	@JsonProperty("EmployeeDetail")
	private Employee employee;
	
	@JsonProperty("Fault")
	private Fault fault;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

	@Override
	public String toString() {
		return "GetEmployeeById [employee=" + employee + ", fault=" + fault + "]";
	}
	
	
}
