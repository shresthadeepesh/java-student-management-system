/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.auth;

import com.techlink.students.Student;
import com.techlink.students.StudentRepository;

import java.util.Optional;

public class AuthService {

    private final StudentRepository studentRepository;

    public AuthService() {
        studentRepository = new StudentRepository();
    }

    public boolean authenticate(String username, String password) {
        return studentRepository.login(username, password).isPresent();
    }

    public Student register(String name, String email, String password) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);

        return studentRepository.register(student);
    }

    public Optional<Student> updatePassword(String email, String oldPassword, String newPassword) {
        Optional<Student> student = studentRepository.findByEmail(email);

        if(student.isPresent() && student.get().getPassword().equals(oldPassword)) {
            student.get().setPassword(newPassword);
            studentRepository.updatePassword(student.get());
            return student;
        }

        return Optional.empty();
    }

}
