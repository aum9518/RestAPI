package com.example.restapi.api;

import com.example.restapi.dto.StudentRequest;
import com.example.restapi.dto.StudentRespons;
import com.example.restapi.entity.Student;
import com.example.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentAPI {
    private final StudentService service;
@GetMapping
     public List<StudentRespons> getAllStudents(){
         return service.getAllStudents();
     }
@PostMapping()
     public StudentRespons saveStudent(@RequestBody StudentRequest student){
           return service.saveStudent(student);
     }
     @GetMapping("/{id}")
   public  StudentRespons getStudentById(@PathVariable Long id){
    return service.getStudentById(id);
   }
   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable Long id){
    service.deleteById(id);
    return "deleted";
   }
   @PutMapping("/{id}")
   public StudentRespons updateStudent(@PathVariable Long id, @RequestBody Student student){
    return service.updateStudent(id,student);
   }
   @GetMapping("/block")
    public List<StudentRespons> getAllStudentByBlocked(@RequestParam(required = false) boolean isBlocked){
            return service.getAllStudentByBlockedOrNotBlocked(isBlocked);
   }

}
