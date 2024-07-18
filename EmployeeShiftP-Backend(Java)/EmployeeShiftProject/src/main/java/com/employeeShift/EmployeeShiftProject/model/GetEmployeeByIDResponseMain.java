package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetEmployeeByIDResponseMain {
	@JsonProperty("GetEmployeeByIdResponse")
	private GetEmployeeById getEmployeeById;

	public GetEmployeeById getGetEmployeeById() {
		return getEmployeeById;
	}

	public void setGetEmployeeById(GetEmployeeById getEmployeeById) {
		this.getEmployeeById = getEmployeeById;
	}

	@Override
	public String toString() {
		return "GetEmployeeByIDResponse [getEmployeeById=" + getEmployeeById + "]";
	}
	
	

}
