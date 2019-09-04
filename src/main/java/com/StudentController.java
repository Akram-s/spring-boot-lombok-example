package com;

import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

import com.model.Student;
import com.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.ApiParam;

@RestController
@Api(value="Student", description="Operations pertaining to student database")
public class StudentController {

@Autowired
	StudentService studentService;
    @GetMapping("/")
    public String index() {
        return "Welcome to student database!";
    }

    @ApiOperation(value = "Search a student with an ID",response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all students"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@ApiParam(value = "Student id to fetch", required = true) @Valid @PathVariable Long id) {
        return studentService.getById(id);
    }

    @ApiOperation(value = "Update student data by id")
    @PutMapping("/updateStudent")
    public Student updateStudent(@ApiParam(value = "Student id to fetch and update", required = true) @Valid @RequestParam Long id, @ApiParam(value = "Student data to be updated in database table", required = true) @Valid @RequestBody Student student) {
        studentService.deleteById(id);
        studentService.save(student);
        return student;
    }

    @ApiOperation(value = "Delete student data by id")
    @DeleteMapping("/deleteStudent/{id}")
    public String removeStudent(@ApiParam(value = "Student data to delete from table", required = true) @Valid @PathVariable Long id) {
        studentService.deleteById(id);
        return "Deleted student  with id:  " + id;
    }

    @ApiOperation(value = "Add a new student",response = Student.class)
    @PostMapping(path="/createStudent", consumes= {"application/json"})
    public Student createStudent(@ApiParam(value = "Student data to be stored in database table", required = true) @Valid @RequestBody Student student) {
        studentService.save(student);
        return student;
    }

}
