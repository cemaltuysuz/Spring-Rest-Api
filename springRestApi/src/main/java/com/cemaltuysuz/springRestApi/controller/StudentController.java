package com.cemaltuysuz.springRestApi.controller;

import com.cemaltuysuz.springRestApi.entity.Student;
import com.cemaltuysuz.springRestApi.exception.ResourceNotFoundException;
import com.cemaltuysuz.springRestApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable long id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        updateStudent.setName(studentDetails.getName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setAge(studentDetails.getAge());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        Student deleteStudent = studentRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        studentRepository.delete(deleteStudent);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
