package com.example.tutorial.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Rishav",
                        22,
                        LocalDate.of(2000,10,17),
                        "rishav3141@gmail.com"
                )
        );
    }
}
