package com.employeeShift.EmployeeShiftProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.employeeShift.EmployeeShiftProject.model.User;
import com.employeeShift.EmployeeShiftProject.repository.UserRepository;

@Configuration
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//load user from dataBase
		User user =userRepository.findByUserName(username);
		return user;
	}

}
