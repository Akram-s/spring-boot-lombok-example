package com;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.model.Student;
import com.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Student", description="Operations pertaining to student database")
public class StudentController {

@Autowired
	StudentService studentService;
    @RequestMapping("/")
    public String index() {
        return "Welcome to student database!";
    }
    @ApiOperation(value = "List all students",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all students"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getAll();
    }

    @ApiOperation(value = "Search a student with an ID",response = Student.class)
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @ApiOperation(value = "Update student data by id")
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student) {
        studentService.deleteById(id);
        studentService.save(student);
        return student;
    }

    @ApiOperation(value = "Delete student data by id")
    @DeleteMapping("/deleteStudent/{id}")
    public String removeStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "Deleted student  with id:  " + id;
    }

    @ApiOperation(value = "Add a new student",response = Student.class)
    @PostMapping(path="/createStudent", consumes= {"application/json"})
    public Student createStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

}
