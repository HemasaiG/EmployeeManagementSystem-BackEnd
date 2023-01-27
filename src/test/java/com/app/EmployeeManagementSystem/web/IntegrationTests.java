package com.app.EmployeeManagementSystem.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.EmployeeManagementSystem.model.Employee;

//@RunWith(SpringRunner.class) - to create spring context and create beans 
@SpringBootTest
public class IntegrationTests {
	
	@Autowired
	private EmployeeController empController;
	
	//Test Pattern Create , Read, Test, Delete, Read -> Check
	
	@Test
	public void IntergrationCRUD() {
		
		//Create
		/*
		 * Employee employee=new Employee("Rahul","KL",30,"kl@gmail.com");
		 * 
		 * ResponseEntity<Employee> emp=empController.createEmployee(employee);
		 * assertEquals(emp.status(200),HttpStatus.OK);
		 */
		
		//Read
		ResponseEntity<Iterable<Employee>> l= empController.getAllEmployees();
		assertEquals(l.status(HttpStatus.OK),HttpStatus.OK);
		
		//Delete
		/*
		 * ResponseEntity<Object> d=empController.deleteEmployee(emp.getBody().getId());
		 * assertEquals(d.status(HttpStatus.OK),HttpStatus.OK);
		 */
		
		
		
		
		
	}
}
