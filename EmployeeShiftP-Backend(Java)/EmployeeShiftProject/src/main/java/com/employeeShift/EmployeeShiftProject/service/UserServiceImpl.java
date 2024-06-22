package com.employeeShift.EmployeeShiftProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.User;
import com.employeeShift.EmployeeShiftProject.repository.EmployeeRepository;
import com.employeeShift.EmployeeShiftProject.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmployeeRepository  employeeRepository;
	
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}
	@Override
	public List<Employee> getAllEmployee(String allocatedBy) {
		//List<Employee> allEmployee = employeeRepository.find
		
		
		return employeeRepository.findByAllocatedBy(allocatedBy);
	}

}
