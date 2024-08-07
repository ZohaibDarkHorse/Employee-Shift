package com.employeeShift.EmployeeShiftProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@Column(name="employeeName",nullable=false)
	private String name;
	@Column
    private String project;
	@Column
	private String emailId;
	@Column
	private String allocatedBy;
	@Column
	private String organization;
	@Column 
	private String profileImage;
	

	public Employee() {
		// Default constructor required by JPA
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(Long id) {
		this.empId = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAllocatedBy() {
		return allocatedBy;
	}
	public void setAllocatedBy(String allocatedBy) {
		this.allocatedBy = allocatedBy;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", project=" + project + ", emailId=" + emailId
				+ ", allocatedBy=" + allocatedBy + ", organization=" + organization + ", profileImage=" + profileImage
				+ "]";
	}
	


	
	
	

}
