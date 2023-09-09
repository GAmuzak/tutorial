package com.example.tutorial.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;

    private LocalDate dob;
    private String email;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
