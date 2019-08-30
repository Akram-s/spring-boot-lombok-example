package com;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.model.Student;
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
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student) {
        studentService.deleteById(id);
        studentService.save(student);
        return student;
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String removeStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "Deleted student  with id:  " + id;
    }
    @PostMapping(path="/createStudent", consumes= {"application/json"})
    public Student createStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

}
