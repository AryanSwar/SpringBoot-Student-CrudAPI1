package com.jsp.student_crud1.service;

import com.jsp.student_crud1.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    Student saveStudent(Student student);

    Student findStudent(int roll);

    List<Student> findAllStudent();

    Student updateStudent(Student student);

    void deleteStudent(int roll);
}
