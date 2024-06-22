package com.employeeShift.EmployeeShiftProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.getById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		

		Long id = employee.getId();
		// TODO Auto-generated method stub
		Optional<Employee> recordExist = employeeRepository.findById(id);
		if(recordExist.isPresent()) {
			Employee existingEmployee = recordExist.get();

			// Update the existing employee's fields with the new values
			//existingEmployee.setId(existingEmployee.getId());
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmailId(employee.getEmailId());
			//existingEmployee.setAdmin(employee.isAdmin());
			existingEmployee.setOrganization(employee.getOrganization());
			existingEmployee.setAllocatedBy(employee.getAllocatedBy());
			existingEmployee.setProject(employee.getProject());
			
			 employeeRepository.save(existingEmployee);
			
		}
		//return employeeRepository.;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> recordExist = employeeRepository.findById(id);
		
		if(recordExist.isPresent()) {
			Employee existingEmployee = recordExist.get();
			employeeRepository.delete(existingEmployee);
		}
		
	}

}
