package com.mongodb.demo.services;

import com.mongodb.demo.StudentRepository;
import com.mongodb.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        studentRepository.insert(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.deleteById(student.getId());
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).get();
    }
}
