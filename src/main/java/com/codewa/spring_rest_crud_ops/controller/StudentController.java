package com.codewa.spring_rest_crud_ops.controller;

import com.codewa.spring_rest_crud_ops.entity.Student;
import com.codewa.spring_rest_crud_ops.repository.StudentRepository;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //delete a student
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        Optional <Student> student = studentRepository.findById(id);
        studentRepository.deleteById(id);
    }

    //update student
    @PutMapping("/student/update/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestBody Student student) {
        Student updatedStudent = studentRepository.findById(id).get();
        updatedStudent.setName(student.getName());
        updatedStudent.setBranch(student.getBranch());
        updatedStudent.setPercentage(student.getPercentage());
        return studentRepository.save(updatedStudent);
    }

}
