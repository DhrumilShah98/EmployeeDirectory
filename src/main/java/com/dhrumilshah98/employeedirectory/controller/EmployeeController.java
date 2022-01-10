package com.dhrumilshah98.employeedirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhrumilshah98.employeedirectory.entity.Employee;
import com.dhrumilshah98.employeedirectory.repository.EmployeeRepository;

/**
 * {@code EmployeeController} class contains the flow control logic for the Employee Directory application.
 * It controls the data flow into the Employee model object and updates the view accordingly.
 * 
 * @author Dhrumil Amish Shah
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping({"/", "/displayEmployees"})
	public ModelAndView displayEmployees() {
		final ModelAndView mav = new ModelAndView("list-employees");
		final List<Employee> employees = employeeRepository.findAll();
		mav.addObject("employees", employees);
		return mav;
	}
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		final ModelAndView mav = new ModelAndView("add-employee-form");
		final Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/displayEmployees";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		final ModelAndView mav = new ModelAndView("add-employee-form");
		final Employee employee = employeeRepository.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return "redirect:/displayEmployees";
	}
}