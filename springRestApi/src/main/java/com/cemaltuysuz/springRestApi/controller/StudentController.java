package com.cemaltuysuz.springRestApi.controller;

import com.cemaltuysuz.springRestApi.entity.Student;
import com.cemaltuysuz.springRestApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/getAllStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
