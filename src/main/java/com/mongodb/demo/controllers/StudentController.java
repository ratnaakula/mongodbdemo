package com.mongodb.demo.controllers;

import com.mongodb.demo.entities.Student;
import com.mongodb.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
