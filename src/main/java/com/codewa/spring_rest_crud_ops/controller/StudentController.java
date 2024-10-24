package com.codewa.spring_rest_crud_ops.controller;

import com.codewa.spring_rest_crud_ops.entity.Student;
import com.codewa.spring_rest_crud_ops.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //get all students
    //url localhost:8081/students
    @GetMapping("/students")
    List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //get student using rollNo
    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return (Optional<Student>) studentRepository.findById(id);
    }

    //add new student
    @PostMapping("/student/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
