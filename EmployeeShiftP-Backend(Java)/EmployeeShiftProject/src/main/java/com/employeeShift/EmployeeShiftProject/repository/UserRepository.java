package com.employeeShift.EmployeeShiftProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeShift.EmployeeShiftProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
