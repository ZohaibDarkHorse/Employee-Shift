package com.employeeShift.EmployeeShiftProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.User;
import com.employeeShift.EmployeeShiftProject.service.EmployeeServiceImpl;
import com.employeeShift.EmployeeShiftProject.service.UserServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("employeeShift/registerUser")
	public  ResponseEntity<User>registerUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userServiceImpl.registerUser(user);
		
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("employeeShift/getAllEmployeeOfOrganization/{allocatedBy}")
	public List<Employee>getAllEmployeeOfOrganization(@PathVariable String allocatedBy){
		return userServiceImpl.getAllEmployee(allocatedBy);

		


}
	 // Step1:Defines the directory to upload images, using the system's current directory
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/images";
    
	@PostMapping("employeeShift/addEmployee")
	public void addEmployee(@ModelAttribute Employee employee,@RequestParam("image") MultipartFile file) throws IOException {
		
		//Step2:// Get the original filename of the uploaded file
		 String originalFilename = file.getOriginalFilename();
		 
		//Step3: Create a path combining the upload directory and the original filename
	        Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
	        
	        // Step4:Ensure that the directory exists, create it if it does not
	        Files.createDirectories(fileNameAndPath.getParent());
	        
	        // Step5:Write the uploaded file to the specified path
	        Files.write(fileNameAndPath, file.getBytes());
	        
	        // Step 6: Set the profile image filename in the employee object
	        employee.setProfileImage(originalFilename);
	        
	        // Save the student object and return the saved object
	        employeeServiceImpl.saveEmployee(employee);

		//employeeServiceImpl.saveEmployee(employee);
		
	}
}
