package com.employeeShift.EmployeeShiftProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeShift.EmployeeShiftProject.model.Employee;
import com.employeeShift.EmployeeShiftProject.model.Fault;
import com.employeeShift.EmployeeShiftProject.model.GetAllEmployee;
import com.employeeShift.EmployeeShiftProject.model.GetAllEmployeeResponseMain;
import com.employeeShift.EmployeeShiftProject.model.GetEmployeeByIDResponseMain;
import com.employeeShift.EmployeeShiftProject.model.GetEmployeeById;
import com.employeeShift.EmployeeShiftProject.model.User;
import com.employeeShift.EmployeeShiftProject.model.UserResponse;
import com.employeeShift.EmployeeShiftProject.model.UserResponseMain;
import com.employeeShift.EmployeeShiftProject.service.EmployeeServiceImpl;
import com.employeeShift.EmployeeShiftProject.service.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

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
	public ResponseEntity<UserResponseMain> registerUser(@RequestBody User user) {
		UserResponseMain userResponseMain = new UserResponseMain();
		UserResponse userResponse = new UserResponse();
		Fault fault = new Fault();

		// Ensure the password is not null before encoding
		if (StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getOrganization())
				|| StringUtils.isBlank(user.getPhoneNumber()) || StringUtils.isBlank(user.getUserName())) {

			fault.setErrorCode(401);
			fault.setMessage("Missing Field Value");
			userResponse.setFault(fault);
			userResponseMain.setUserResponse(userResponse);
			return ResponseEntity.badRequest().body(userResponseMain);
		}

		User Newuser = userServiceImpl.getUserByUserName(user.getUserName());

		if (Newuser!=null) {
			fault.setErrorCode(409);
			fault.setMessage("User Already Exist");
			userResponse.setFault(fault);
			userResponseMain.setUserResponse(userResponse);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(userResponseMain);
		}
      
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try {
			userServiceImpl.registerUser(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.created(null).build();
	}

	@GetMapping("employeeShift/getAllEmployeeOfOrganization/{allocatedBy}")
	public ResponseEntity<GetAllEmployeeResponseMain> getAllEmployeeOfOrganization(@PathVariable String allocatedBy) {

		GetAllEmployeeResponseMain getAllEmployeeResponseMain = new GetAllEmployeeResponseMain();

		GetAllEmployee getAllEmployee = new GetAllEmployee();

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = userServiceImpl.getAllEmployee(allocatedBy);
		} catch (Exception e) {
			Fault fault = new Fault();
			fault.setErrorCode(500);
			fault.setMessage(e.getMessage());

			getAllEmployee.setFault(fault);
			getAllEmployeeResponseMain.setGetAllEmployee(getAllEmployee);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getAllEmployeeResponseMain);
		}
		getAllEmployee.setEmployeeList(employeeList);

		getAllEmployeeResponseMain.setGetAllEmployee(getAllEmployee);

		return ResponseEntity.ok(getAllEmployeeResponseMain);

	}

	// This is using path variable
	@GetMapping("employeeShift/getEmployeeById/{id}")
	public ResponseEntity<GetEmployeeByIDResponseMain> getEmployeeById(@PathVariable Long id) {

		GetEmployeeByIDResponseMain getEmployeeByIDResponseMain = new GetEmployeeByIDResponseMain();

		GetEmployeeById getEmployeeById = new GetEmployeeById();

		Optional<Employee> emp;
		try {
			emp = employeeServiceImpl.getEmployeeById(id);
		} catch (Exception e) {

			Fault fault = new Fault();
			fault.setErrorCode(500);
			fault.setMessage(e.getMessage());
			getEmployeeById.setFault(fault);
			getEmployeeByIDResponseMain.setGetEmployeeById(getEmployeeById);
			return ResponseEntity.badRequest().body(getEmployeeByIDResponseMain);

		}
		if (!emp.isPresent()) {
			Fault fault = new Fault();
			fault.setErrorCode(500);
			fault.setMessage("Employee not Found");
			getEmployeeById.setFault(fault);
			getEmployeeByIDResponseMain.setGetEmployeeById(getEmployeeById);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getEmployeeByIDResponseMain);
		} else {
			getEmployeeById.setEmployee(emp.get());
			getEmployeeByIDResponseMain.setGetEmployeeById(getEmployeeById);
		}

		// return employeeServiceImpl.getEmployeeById(id);
		return ResponseEntity.ok(getEmployeeByIDResponseMain);
	}

	// Step1:Defines the directory to upload images, using the system's current
	// directory
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/images";

	@PostMapping("employeeShift/addEmployee")
	public ResponseEntity<String> addEmployee(@ModelAttribute Employee employee,
			@RequestParam("image") MultipartFile file) {

		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File not Uploaded");
			}

			// Step2:// Get the original filename of the uploaded file
			String originalFilename = file.getOriginalFilename();

			// Step3: Create a path combining the upload directory and the original filename
			Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);

			// Step4:Ensure that the directory exists, create it if it does not
			Files.createDirectories(fileNameAndPath.getParent());

			// Step5:Write the uploaded file to the specified path
			Files.write(fileNameAndPath, file.getBytes());

			// Step 6: Set the profile image filename in the employee object
			employee.setProfileImage(originalFilename);

			// Save the student object and return the saved object
			employeeServiceImpl.saveEmployee(employee);

			// employeeServiceImpl.saveEmployee(employee);

			return ResponseEntity.ok("Record added");

		} catch (IOException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@PutMapping("employeeShift/updateEmployee")
	public ResponseEntity<String> updateEmployee(@ModelAttribute Employee employee,
			@RequestParam("image") MultipartFile file) throws IOException {

		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File not Uploaded");
			}
			// Step2:// Get the original filename of the uploaded file
			String originalFilename = file.getOriginalFilename();

			// Step3: Create a path combining the upload directory and the original filename
			Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);

			// Step4:Ensure that the directory exists, create it if it does not
			Files.createDirectories(fileNameAndPath.getParent());

			// Step5:Write the uploaded file to the specified path
			Files.write(fileNameAndPath, file.getBytes());

			// Step 6: Set the profile image filename in the employee object
			employee.setProfileImage(originalFilename);

			// Save the student object and return the saved object
			employeeServiceImpl.updateEmployee(employee);
			
			return ResponseEntity.ok().build();

			// employeeServiceImpl.saveEmployee(employee);
		} catch (IOException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("employeeShift/deleteEmployee/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			Optional<Employee> emp;
			emp = employeeServiceImpl.getEmployeeById(id);
			if(!emp.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Record Found To Delete");
			}
			
		employeeServiceImpl.deleteEmployee(id);
		return ResponseEntity.ok("Record Deleted SucessFully");
		}
		catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
		}
	}
	
}
