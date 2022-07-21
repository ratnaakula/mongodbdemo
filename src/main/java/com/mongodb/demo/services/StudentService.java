package com.mongodb.demo.services;

import com.mongodb.demo.repositories.StudentRepository;
import com.mongodb.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getAllStudentsByNameAndMail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getAllStudentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student>  getAllStudentsByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentsWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    public List<Student> bySubjectName(String subject) {
        return studentRepository.findBySubjectsSubjectName(subject);
    }

    public List<Student>  byEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }
}
