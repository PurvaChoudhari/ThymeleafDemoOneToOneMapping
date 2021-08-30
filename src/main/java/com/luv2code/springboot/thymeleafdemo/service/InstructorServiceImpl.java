package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.InstructorRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Instructor;



@Service
public class InstructorServiceImpl implements InstructorService {

	private InstructorRepository instructorRepository;
	
	@Autowired
	public InstructorServiceImpl(InstructorRepository theInstructorRepository) {
		instructorRepository = theInstructorRepository;
	}
	
	@Override
	public List<Instructor> findAll() {
		return instructorRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Instructor findById(int theId) {
		Optional<Instructor> result = instructorRepository.findById(theId);
		
		Instructor theInstructor = null;
		
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
	public void save(Instructor theInstructor) {
		instructorRepository.save(theInstructor);
	}

	@Override
	public void deleteById(int theId) {
		instructorRepository.deleteById(theId);
	}

}






