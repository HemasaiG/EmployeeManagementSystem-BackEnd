package com.app.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.EmployeeManagementSystem.model.Employee;
import com.app.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Iterable<Employee> getAllEmployees() {
		Iterable<Employee> employees= repo.findAll();
		System.out.println(employees);
		return employees;
	}

	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployeeById(Integer id) {
		return repo.findOne(id);
		
	}

	public void deleteEmployee(Integer id) {
		 repo.delete(id);
	}

}
