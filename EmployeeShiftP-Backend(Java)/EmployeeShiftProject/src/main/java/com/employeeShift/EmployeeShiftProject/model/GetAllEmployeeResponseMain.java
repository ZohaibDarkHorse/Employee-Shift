package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAllEmployeeResponseMain {

	@JsonProperty("GetAllEmployeeResponse")
	private GetAllEmployee getAllEmployee;


	public GetAllEmployee getGetAllEmployee() {
		return getAllEmployee;
	}

	public void setGetAllEmployee(GetAllEmployee getAllEmployee) {
		this.getAllEmployee = getAllEmployee;
	}

	@Override
	public String toString() {
		return "GetAllEmployeeResponseMain [getAllEmployee=" + getAllEmployee + "]";
	}



}
