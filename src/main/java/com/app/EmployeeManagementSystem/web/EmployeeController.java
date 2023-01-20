package com.app.EmployeeManagementSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.EmployeeManagementSystem.model.Employee;
import com.app.EmployeeManagementSystem.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	// get all
	@GetMapping("employees")
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		return new ResponseEntity<Iterable<Employee>>(service.getAllEmployees(),HttpStatus.OK);
	}
	
	@PostMapping("employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee ) {
		return new ResponseEntity<Employee>(service.createEmployee(employee),HttpStatus.OK);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee employee=service.getEmployeeById(id);
		if(employee!=null)
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("employees/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee) {
		Employee employee=service.getEmployeeById(updatedEmployee.getId());
		System.out.println(employee);
		if(employee!=null) {
			return new ResponseEntity<Employee>(service.createEmployee(updatedEmployee),HttpStatus.OK);
		}	
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("employees/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id")Integer id) {
		Employee emp=service.getEmployeeById(id);
		if(emp!=null) {
			service.deleteEmployee(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
	
	

}
