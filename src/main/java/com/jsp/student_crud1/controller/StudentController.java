package com.jsp.student_crud1.controller;

import com.jsp.student_crud1.model.Student;
import com.jsp.student_crud1.service.StudentService;
import com.jsp.student_crud1.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    //tight coupling - specialization

//    StudentService service = new StudentServiceImpl();

    @Autowired
    StudentService service;

    //removing the end point to achieve handle crud by using @RequestMapping
//    @PostMapping("student/save")
    @PostMapping
    public Student save(@RequestBody Student student){
        return service.saveStudent(student);

    }

//    @GetMapping("student/find")
    @GetMapping
    public Student findById(@RequestParam int roll)
    {
        return service.findStudent(roll);
    }

    //in this time creating GetMapping two method at that time difference between
    @GetMapping("/find")
    public List<Student> findAllStudents()
    {
        return service.findAllStudent();
    }

//    @PutMapping("/student/update")
    @PutMapping
    public Student updateStudent(@RequestBody Student student)
    {
        return service.updateStudent(student);
    }

//    @DeleteMapping("/student/delete")
    @DeleteMapping
    public String delete(@RequestParam int roll)
    {
        service.deleteStudent(roll);
        return "deleted successfully";
    }
}
