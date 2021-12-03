/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.common.students;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public List<Student> all() {
        return studentRepository.all();
    }

    public Optional<Student> show(int id) {
        return studentRepository.show(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(int id, Student student) {
        return studentRepository.update(id, student);
    }

    public Student delete(Student student) {
        return studentRepository.delete(student);
    }
}
