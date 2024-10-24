package com.codewa.spring_rest_crud_ops.controller;

import com.codewa.spring_rest_crud_ops.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    //get all students
    //url localhost:8081/students
    @GetMapping("/students")
    List<Student> getAllStudents() {
        return null;
    }
}
