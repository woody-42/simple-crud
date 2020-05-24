package com.luv2code.springboot.Thymeleafdemo.controller;



import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.Thymeleafdemo.entity.Employee;
import com.luv2code.springboot.Thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
		
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
			
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
			
		// add to the spring model
		theModel.addAttribute("employee", theEmployees);
			
		return "employees/list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// create the model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee" , employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		// get employee from service
		Employee employee = employeeService.findById(id);
		
		//set employee as a model attribute to pre populate form
		model.addAttribute("employee", employee);
		
		// Sends data to the form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save the employee
		employeeService.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
		

}

