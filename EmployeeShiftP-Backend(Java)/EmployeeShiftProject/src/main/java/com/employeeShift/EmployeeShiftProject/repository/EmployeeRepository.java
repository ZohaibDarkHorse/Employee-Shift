package com.employeeShift.EmployeeShiftProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeShift.EmployeeShiftProject.model.Employee;


//<Employee,Long> Employee suggest we are going to perform operation Employee model
//Long suggest the model has unique Id that is of Long type
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByAllocatedBy(String allocatedBy);
    
   
}
