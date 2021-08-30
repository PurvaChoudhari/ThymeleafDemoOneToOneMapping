package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.luv2code.springboot.thymeleafdemo.entity.Instructor;
import com.luv2code.springboot.thymeleafdemo.entity.InstructorDetails;
import com.luv2code.springboot.thymeleafdemo.service.InstructorDetailsService;
import com.luv2code.springboot.thymeleafdemo.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	private InstructorService instructorService;
	
	
	public InstructorController(InstructorService theInstructorService) {
		instructorService = theInstructorService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Instructor> theEmployees = instructorService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "instructor/list-instructor";
	}
	@GetMapping("/showFormForDetails")
	public String listInstructors(@RequestParam("employeeId") int theId,
			Model theModel) {
		
				// get the employee from the service
				Instructor theEmployee = instructorService.findById(theId);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployee);
		
		return "instructor/list-instructorDetails";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Instructor theInstructor = new Instructor();
		
		theModel.addAttribute("instructor", theInstructor);
		
		return "instructor/instructor-form";
	}
	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Instructor theEmployee = instructorService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("instructor", theEmployee);
		
		// send over to our form
		return "instructor/instructor-form";			
	}
	
	@GetMapping("/showFormForUpdateDetails")
	public String showFormForDetailsUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Instructor theEmployee = instructorService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("instructor", theEmployee);
		
		// send over to our form
		return "instructor/instructor-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("instructor") Instructor theEmployee) {
		
		// save the employee
		instructorService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/instructor/list";
	}
	
	
	
	
}












