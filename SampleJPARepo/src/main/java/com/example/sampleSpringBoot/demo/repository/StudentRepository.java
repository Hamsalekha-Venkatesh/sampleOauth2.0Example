package com.example.sampleSpringBoot.demo.repository;

import com.example.sampleSpringBoot.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student save(Student student);
}
