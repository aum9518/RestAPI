package com.example.restapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
     private Long id;
     private String name;
     private String email;
     private int age;
     private LocalDate createdAt;
     private Boolean isBlocked;
}
