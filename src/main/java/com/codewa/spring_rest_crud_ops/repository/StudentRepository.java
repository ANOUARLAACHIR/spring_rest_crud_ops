package com.codewa.spring_rest_crud_ops.repository;

import com.codewa.spring_rest_crud_ops.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
