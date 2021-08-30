package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAll();
	
	public Instructor findById(int theId);
	
	public void save(Instructor theInstructor);
	
	public void deleteById(int theId);
	
}
