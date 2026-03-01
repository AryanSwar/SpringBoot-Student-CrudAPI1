package com.jsp.student_crud1.repository;

import com.jsp.student_crud1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

//    @Query("select s form Student s where s.email=?1")
    List<Student> findByEmail(String email);
}
