package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseMain {
    @JsonProperty("UserResponse")
	private UserResponse userResponse;

	public UserResponse getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}

	@Override
	public String toString() {
		return "UserResponseMain [userResponse=" + userResponse + "]";
	}
	
}
