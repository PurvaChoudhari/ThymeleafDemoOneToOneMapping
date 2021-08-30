package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.InstructorDetails;

public interface InstructorDetailsService {

	public List<InstructorDetails> findAll();
	
	public InstructorDetails findById(int theId);
	
	public void save(InstructorDetails theInstructor);
	
	public void deleteById(int theId);
	
}
