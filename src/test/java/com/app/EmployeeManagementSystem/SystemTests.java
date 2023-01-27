package com.app.EmployeeManagementSystem;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.EmployeeManagementSystem.model.Employee;

public class SystemTests {

	@Test
	public void RESTCRUD() {

		RestTemplate rest = new RestTemplate();
		String url = "http://localhost:4000/api/employees";

		Employee emp = new Employee("rohit", "sharma", 35, "rohits@outlook.com");

		ResponseEntity<Employee> entity = rest.postForEntity(url, emp, Employee.class);

		Employee[] emplist = rest.getForObject(url, Employee[].class);
		Employee e = emplist[emplist.length - 1];

		assertEquals(e.getFirstName(), "rohit");

		
		rest.delete(url+"/delete/"+entity.getBody().getId()); Employee[]
		emplist2=rest.getForObject(url, Employee[].class);
		assertTrue(emplist2.length==emplist.length-1);
		 
	}

}
