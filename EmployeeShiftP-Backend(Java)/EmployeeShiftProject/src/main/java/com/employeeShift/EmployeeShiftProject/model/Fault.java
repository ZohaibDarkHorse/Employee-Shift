package com.employeeShift.EmployeeShiftProject.model;

public class Fault {

private long errorCode;
private String message;


public long getErrorCode() {
	return errorCode;
}
public void setErrorCode(long errorCode) {
	this.errorCode = errorCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "Fault [errorCode=" + errorCode + ", message=" + message + "]";	
	
}
}
