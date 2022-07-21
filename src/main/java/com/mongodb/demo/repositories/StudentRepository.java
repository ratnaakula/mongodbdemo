package com.mongodb.demo.repositories;

import com.mongodb.demo.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String department);

    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailIsLike(String email);
}
