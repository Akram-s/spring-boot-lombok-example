package com.services;

import java.util.List;

import com.dao.Student;
import com.dao.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

    public void save(Student student){
		studentRepository.save(student);

	}

    public List<Student> getAll(){
		return studentRepository.findAll();
	}

    public Student getById(Long id){

		return studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id: " + id + " not found."));
	}
}