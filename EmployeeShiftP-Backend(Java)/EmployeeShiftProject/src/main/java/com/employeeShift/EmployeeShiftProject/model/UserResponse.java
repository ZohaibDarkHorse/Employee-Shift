package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

	private User user;
	
	private Fault fault;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

	@Override
	public String toString() {
		return "UserResponse [user=" + user + ", fault=" + fault + "]";
	}
	
}
