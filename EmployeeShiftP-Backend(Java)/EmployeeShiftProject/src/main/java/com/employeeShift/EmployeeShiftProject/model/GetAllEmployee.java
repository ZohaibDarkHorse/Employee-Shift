package com.employeeShift.EmployeeShiftProject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllEmployee {
	@JsonProperty("EmployeeList")
	private List<Employee> employeeList;
	private Fault fault;
	

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	
	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

	@Override
	public String toString() {
		return "GetAllEmployee [employeeList=" + employeeList + ", fault=" + fault + "]";
	}


}
