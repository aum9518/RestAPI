package com.example.restapi.service.serviceImpl;

import com.example.restapi.dto.StudentRequest;
import com.example.restapi.dto.StudentRespons;
import com.example.restapi.entity.Student;
import com.example.restapi.exception.MyException;
import com.example.restapi.repository.StudentRepository;
import com.example.restapi.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    @Override
    public StudentRespons saveStudent(StudentRequest student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        student1.setCreatedAt(LocalDate.now());
        student1.setIsBlocked(false);
        repository.save(student1);
        return new StudentRespons(student1.getId(), student1.getName(), student1.getEmail(),student1.getAge());
    }

    @Override
    public List<StudentRespons> getAllStudents() {
        return repository.getAllStudents();
    }

    @Override
    public StudentRespons getStudentById(Long id) {
        try {
            Student student = repository.findById(id).orElseThrow(() -> new MyException("do not found"));
            return new StudentRespons(student.getId(), student.getName(), student.getEmail(), student.getAge());
        }catch(MyException e ){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public StudentRespons updateStudent(Long id, Student newStudent) {
        try {
            Student student = repository.findById(id).orElseThrow(() -> new MyException("do not found"));
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            student.setAge(newStudent.getAge());
            repository.save(student);

            return new StudentRespons(student.getId(), student.getName(), student.getEmail(), student.getAge());
        }catch(MyException e ){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteById(Long id) {
        try{
            if (repository.existsById(id)){
                repository.deleteById(id);
            }else throw new MyException("not found");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return "Student deleted";
    }

    @Override
    public List<StudentRespons> getAllStudentByBlockedOrNotBlocked(boolean isBlocked) {
        return repository.getAllByIsBlocked(isBlocked);
    }
}
