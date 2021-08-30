package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.InstructorDetails;

public interface InstructorDetailsRepository extends JpaRepository<InstructorDetails, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<InstructorDetails> findAll();
	
}
