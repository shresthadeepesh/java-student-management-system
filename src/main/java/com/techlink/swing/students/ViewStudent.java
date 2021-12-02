/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.students;

import com.techlink.students.Student;
import com.techlink.students.StudentService;
import com.techlink.swing.FormLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class ViewStudent extends JFrame implements ActionListener {

    private final StudentService studentService;

    public ViewStudent(int id) {
        studentService = new StudentService();
        Optional<Student> student = studentService.show(id);

        Container container = getContentPane();

        FormLabel titleLabel = new FormLabel("Student Details");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
        container.add(titleLabel);

        if(student.isPresent()) {
            FormLabel idLabel = new FormLabel(String.format("ID: %d", student.get().getId()));
            idLabel.setBounds(100, 120, 100, 30);
            container.add(idLabel);

            FormLabel nameLabel = new FormLabel(String.format("Name: %s", student.get().getName()));
            nameLabel.setBounds(100, 140, 200, 30);
            container.add(nameLabel);

            FormLabel emailLabel = new FormLabel(String.format("Email: %s", student.get().getEmail()));
            emailLabel.setBounds(100, 160, 200, 30);
            container.add(emailLabel);

            FormLabel addressLabel = new FormLabel(String.format("Address: %s", student.get().getAddress()));
            addressLabel.setBounds(100, 180, 200, 30);
            container.add(addressLabel);

            FormLabel gradeLabel = new FormLabel(String.format("Grade: %s", student.get().getGrade()));
            gradeLabel.setBounds(100, 200, 200, 30);
            container.add(gradeLabel);

            FormLabel guardianLabel = new FormLabel(String.format("Guardian Name: %s", student.get().getGuardianName()));
            guardianLabel.setBounds(100, 220, 200, 30);
            container.add(guardianLabel);

            FormLabel phoneLabel = new FormLabel(String.format("Address: %s", student.get().getPhone()));
            phoneLabel.setBounds(100, 240, 200, 30);
            container.add(phoneLabel);

            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = new java.sql.Date(student.get().getDob().getTime()).toLocalDate();
            int age = Period.between(birthDate, currentDate).getYears();

            FormLabel ageLabel = new FormLabel(String.format("Age: %s", age));
            ageLabel.setBounds(100, 260, 200, 30);
            container.add(ageLabel);

            FormLabel joinedAtLabel = new FormLabel(String.format("Joined At: %s", student.get().getJoinedAt()));
            joinedAtLabel.setBounds(100, 280, 200, 30);
            container.add(joinedAtLabel);
        }

        setLayout(null);
        setSize(800, 800);
        setTitle("Student Details");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
