package com.example.sampleSpringBoot.demo.controller;

import com.example.sampleSpringBoot.demo.model.Student;
import com.example.sampleSpringBoot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method  = RequestMethod.POST)
    public void save(@RequestBody Student student) {
        studentService.save(student);
        // return "hello";
    }
}
