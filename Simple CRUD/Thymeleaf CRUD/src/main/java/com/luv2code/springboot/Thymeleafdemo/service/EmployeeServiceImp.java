package com.luv2code.springboot.Thymeleafdemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.Thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.Thymeleafdemo.entity.Employee;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		}
		else {
			throw new RuntimeException("Did not find product with id - " + id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
