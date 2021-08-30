package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.InstructorDetailsRepository;
import com.luv2code.springboot.thymeleafdemo.dao.InstructorRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Instructor;
import com.luv2code.springboot.thymeleafdemo.entity.InstructorDetails;



@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

	private InstructorDetailsRepository instructorDetailsRepository;
	
	@Autowired
	public InstructorDetailsServiceImpl(InstructorDetailsRepository theInstructorRepository) {
		instructorDetailsRepository = theInstructorRepository;
	}
	
	@Override
	public List<InstructorDetails> findAll() {
		return instructorDetailsRepository.findAll();
	}

	@Override
	public InstructorDetails findById(int theId) {
		Optional<InstructorDetails> result = instructorDetailsRepository.findById(theId);
		
		InstructorDetails theInstructor = null;
		
		if (result.isPresent()) {
			theInstructor = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find  id - " + theId);
		}
		
		return theInstructor;
	}

	@Override
	public void save(InstructorDetails theInstructor) {
		instructorDetailsRepository.save(theInstructor);
	}

	@Override
	public void deleteById(int theId) {
		instructorDetailsRepository.deleteById(theId);
	}

}






