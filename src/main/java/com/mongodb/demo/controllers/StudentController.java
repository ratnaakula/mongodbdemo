package com.mongodb.demo.controllers;

import com.mongodb.demo.entities.Department;
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


    @GetMapping("/id/{id}")
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

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getAllStudentsByName(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getAllStudentsByName(name), HttpStatus.FOUND);
    }

    @GetMapping("/byNameAndMail")
    public ResponseEntity<List<Student>> getAllStudentsByNameAndMail(@RequestParam String name, @RequestParam String mail) {
        return new ResponseEntity<>(studentService.getAllStudentsByNameAndMail(name, mail), HttpStatus.FOUND);
    }

    @GetMapping("/byNameOrMail")
    public ResponseEntity<List<Student>> getAllStudentsByNameOrMail(@RequestParam String name, @RequestParam String mail) {
        return new ResponseEntity<>(studentService.getAllStudentsByNameOrMail(name, mail), HttpStatus.FOUND);
    }

    @GetMapping("/allWithPagination")
    public ResponseEntity<List<Student>> getAllStudentsByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return new ResponseEntity<>(studentService.getAllStudentsByPagination(pageNo, pageSize), HttpStatus.FOUND);
    }

    @GetMapping("/allWithSorting")
    public ResponseEntity<List<Student>> getAllStudentsWithSorting() {
        return new ResponseEntity<>(studentService.getAllStudentsWithSorting(), HttpStatus.FOUND);
    }

    @GetMapping("/byDepartmentName")
    public ResponseEntity<List<Student>> byDepartmentName(@RequestParam String department) {
        return new ResponseEntity<>(studentService.byDepartmentName(department), HttpStatus.FOUND);
    }

    @GetMapping("/bySubjectName")
    public ResponseEntity<List<Student>> bySubjectName(@RequestParam String subject) {
        return new ResponseEntity<>(studentService.bySubjectName(subject), HttpStatus.FOUND);
    }

    @GetMapping("/byEmailLike")
    public ResponseEntity<List<Student>> byEmailLike(@RequestParam String email) {
        return new ResponseEntity<>(studentService.byEmailLike(email), HttpStatus.FOUND);
    }
}
