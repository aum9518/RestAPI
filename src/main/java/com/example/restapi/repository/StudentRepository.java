package com.example.restapi.repository;

import com.example.restapi.dto.StudentRespons;
import com.example.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select new com.example.restapi.dto.StudentRespons(s.id,s.name,s.email,s.age) from Student s")
    List<StudentRespons> getAllStudents();
    List<StudentRespons> getAllByIsBlocked(boolean isBlocked);
}