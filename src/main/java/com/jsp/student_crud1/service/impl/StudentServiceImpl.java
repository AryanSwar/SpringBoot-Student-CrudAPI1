package com.jsp.student_crud1.service.impl;

import com.jsp.student_crud1.model.Student;
import com.jsp.student_crud1.repository.StudentRepository;
import com.jsp.student_crud1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    //replace of autowired using @RequiredArgsConstructor
//    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(int roll) {


        return studentRepository.findById(roll).orElseThrow(()->new RuntimeException("Student not found"));
    }
    @Override
    public List<Student> findAllStudent()
    {
        return studentRepository.findAll();
    }
    @Override
    public Student updateStudent(Student student)
    {
        Student student1 = studentRepository.findById(student.getRoll()).orElseThrow(()->new RuntimeException("Student not found"));
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int roll)
    {
        Student student = studentRepository.findById(roll).orElseThrow(()->new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }


    @Override
    public List<Student> findByEmail(String email)
    {
        return studentRepository.findByEmail(email);
    }
}
