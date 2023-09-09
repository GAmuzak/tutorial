package com.example.tutorial.student;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.Month.AUGUST;
import static java.time.Month.OCTOBER;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @PostConstruct
    public void init(){
        Student rishav = new Student(
                1L,
                "Rishav",
                LocalDate.of(2000, OCTOBER, 17),
                "rishav3141@gmail.com"
        );
        Student arushee = new Student(
                2L,
                "Arushee",
                LocalDate.of(2002, AUGUST, 22),
                "arushee2000@gmail.com"
        );
        studentRepository.saveAll(
                List.of(rishav, arushee)
        );
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) throw new IllegalStateException("Student with id " + studentId + " does not exist!");
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String newName, String newEmail) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist!"));
        if (newName != null && !newName.isEmpty()) {
            student.setName(newName);
        }
        if (newEmail != null && !newEmail.isEmpty()) {
            Optional<Student> present = studentRepository.findStudentByEmail(newEmail);
            if (present.isPresent()) throw new IllegalStateException("Email already taken!");
            student.setEmail(newEmail);
        }
    }
}
