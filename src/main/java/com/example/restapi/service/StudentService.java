package com.example.restapi.service;

import com.example.restapi.dto.StudentRequest;
import com.example.restapi.dto.StudentRespons;
import com.example.restapi.entity.Student;

import java.util.List;

public interface StudentService {

        StudentRespons saveStudent(StudentRequest student);
        List<StudentRespons> getAllStudents();
        StudentRespons getStudentById(Long id);
        StudentRespons updateStudent(Long id,Student newStudent);
        String deleteById(Long id);
        List<StudentRespons> getAllStudentByBlockedOrNotBlocked(boolean isBlocked);
    }


