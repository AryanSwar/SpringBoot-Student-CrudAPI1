package com.jsp.student_crud1.controller;

import com.jsp.student_crud1.model.Student;
import com.jsp.student_crud1.service.StudentService;
import com.jsp.student_crud1.service.impl.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    //tight coupling - specialization

//    StudentService service = new StudentServiceImpl();

    //replace of autowired using RequiredArgConstructor
//    @Autowired
    private final StudentService service;

    //creating documentation of project of Student-crud1
    @Operation(summary = "create object of Student")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "invalid data")
    @ApiResponse(responseCode = "500", description = "internal server error")


    //using ResponseEntity to which response send to client/user
    //removing the end point to achieve handle crud by using @RequestMapping
//    @PostMapping("student/save")
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(student));


    }

//    @GetMapping("student/find")
    @GetMapping
    public ResponseEntity<Student> findById(@RequestParam int roll)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findStudent(roll));

    }

    //in this time creating GetMapping two method at that time difference between
    @GetMapping("/find")
    public ResponseEntity<List<Student>> findAllStudents()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllStudent());

    }

//    @PutMapping("/student/update")
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateStudent(student));

    }

//    @DeleteMapping("/student/delete")
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam int roll)
    {

        service.deleteStudent(roll);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");

    }


    @GetMapping("/find/{email}")
    public ResponseEntity<List<Student>> findByEmail(@PathVariable String email)
    {
        return ResponseEntity.ok(service.findByEmail(email));
    }
}
