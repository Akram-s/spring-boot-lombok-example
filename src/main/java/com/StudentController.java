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
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam Long id) {
        return "Update student data for the given id!";
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String removeStudent(@PathVariable Long id) {
        Student s = studentService.getById(id);
        studentService.delete(s);
        return "Deleted student  with id:  " + id;
    }
    @PostMapping(path="/createStudent", consumes= {"application/json"})
    public Student createStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

}
