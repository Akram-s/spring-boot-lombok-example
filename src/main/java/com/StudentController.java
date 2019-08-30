package com;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String updateStudent() {
        return "Update student data for the given id!";
    }
    @RequestMapping("/deleteStudent")
    public String removeStudent() {
        return "Delete student!";
    }
    @RequestMapping("/createStudent")
    public String createStudent() {
        return "Create student!";
    }

}
