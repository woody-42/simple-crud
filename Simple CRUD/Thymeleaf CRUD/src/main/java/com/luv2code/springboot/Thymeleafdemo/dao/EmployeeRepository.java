package com.luv2code.springboot.Thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.Thymeleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// sort by last name
	//find all by...
	// then sort
	public List<Employee> findAllByOrderByLastNameAsc();
}
