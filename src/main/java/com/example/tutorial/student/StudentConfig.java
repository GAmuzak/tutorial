package com.example.tutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student rishav = new Student(
                    "Rishav",
                    LocalDate.of(2000, OCTOBER, 17),
                    "rishav3141@gmail.com"
            );
            Student arushee = new Student(
                    "Arushee",
                    LocalDate.of(2002, AUGUST, 22),
                    "arushee2000@gmail.com"
            );
            repository.saveAll(
                    List.of(rishav, arushee)
            );
        };
    }
}
