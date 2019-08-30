package com;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.dao.Student;
import com.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

@Autowired
	StudentService studentService;
    @RequestMapping("/")
    public String index() {
        return "Welcome to student database!";
    }
    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getAll();
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam Long id) {
        return "Update student data for the given id!";
    }
    @RequestMapping("/deleteStudent/{id}")
    public String removeStudent(@PathVariable Long id) {
        return "Delete student!";
    }
    @RequestMapping("/createStudent")
    public String createStudent(Student student) {
        studentService.save(student);
        return "Create student!";
    }

}
