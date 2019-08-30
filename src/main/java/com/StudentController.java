package com;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to student database!";
    }
    @RequestMapping("/getStudents")
    public String getStudents() {
        return "List all students from database!";
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
    public String createStudent() {
        return "Create student!";
    }

}
