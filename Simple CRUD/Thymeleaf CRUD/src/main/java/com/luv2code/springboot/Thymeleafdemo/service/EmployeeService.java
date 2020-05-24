package com.luv2code.springboot.Thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.Thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee product);
	
	public void deleteById(int id);
}
