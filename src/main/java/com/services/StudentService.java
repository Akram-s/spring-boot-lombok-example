package com.services;


import com.model.Student;
import com.dao.StudentRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

    public void save(Student student){
		studentRepository.save(student);

	}

    public void delete(Student student){
        studentRepository.delete(student);

    }
    public void deleteById(Long id){
        studentRepository.deleteById(id);

    }

    public Student getById(Long id){

		return studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id: " + id + " not found."));
	}
}