package com.example.sampleSpringBoot.demo.service;

import com.example.sampleSpringBoot.demo.model.Student;
import com.example.sampleSpringBoot.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
