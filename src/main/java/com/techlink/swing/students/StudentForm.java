/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.students;

import com.techlink.common.students.Student;
import com.techlink.common.students.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentForm extends JFrame implements ActionListener {
    private final Container container;
    private final JButton submitButton;
    private final JLabel titleLabel, nameLabel, emailLabel, addressLabel, gradeLabel, dobLabel, phoneLabel, guardianNameLabel, genderLabel, joinedAtLabel, passwordLabel;
    private final JTextField emailField, nameField, addressField, gradeField, dobField, phoneField, guardianNameField, joinedAtField;
    private final JPasswordField passwordField;
    private final JComboBox<String> genderComboBox;

    public StudentForm() {

        container = getContentPane();

        titleLabel = new JLabel("Add Student");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 250, 30);
        container.add(titleLabel);

        nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(100, 150, 120, 30);
        container.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 150, 200, 30);
        container.add(nameField);

        emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(100, 200, 120, 30);
        container.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 200, 200, 30);
        container.add(emailField);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 250, 120, 30);
        container.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200, 250, 200, 30);
        container.add(addressField);

        gradeLabel = new JLabel("Grade");
        gradeLabel.setBounds(100, 300, 120, 30);
        container.add(gradeLabel);

        gradeField = new JTextField();
        gradeField.setBounds(200, 300, 200, 30);
        container.add(gradeField);

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(100, 350, 120, 30);
        container.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(200, 350, 200, 30);
        container.add(dobField);

        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(100, 400, 120, 30);
        container.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 400, 200, 30);
        container.add(phoneField);

        guardianNameLabel = new JLabel("Guardian Name");
        guardianNameLabel.setBounds(100, 450, 120, 30);
        container.add(guardianNameLabel);

        guardianNameField = new JTextField();
        guardianNameField.setBounds(200, 450, 200, 30);
        container.add(guardianNameField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(100, 500, 120, 30);
        container.add(genderLabel);

        String[] genders = {"Male", "Female", "Others"};

        genderComboBox = new JComboBox<String>(genders);
        genderComboBox.setBounds(200, 500, 200, 30);
        container.add(genderComboBox);

        joinedAtLabel = new JLabel("Joined At");
        joinedAtLabel.setBounds(100, 550, 120, 30);
        container.add(joinedAtLabel);

        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        joinedAtField = new JTextField(simpleDateFormat.format(currentDate));
        joinedAtField.setBounds(200, 550, 200, 30);
        container.add(joinedAtField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 600, 120, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 600, 200, 30);
        container.add(passwordField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 650, 120, 30);
        submitButton.addActionListener(this);
        container.add(submitButton);

        setLayout(null);
        setSize(500, 800);
        setTitle("Register");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String address = addressField.getText();
            String grade = gradeField.getText();
            String phone = phoneField.getText();
            String guardianName = guardianNameField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            Date dob = null;
            Date joinedAt = null;
            try {
                dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobField.getText());
                joinedAt = new SimpleDateFormat("yyyy-MM-dd").parse(joinedAtField.getText());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            //validate fields
            if(name.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty() ||
                    grade.isEmpty() || phone.isEmpty() || guardianName.isEmpty() ||
                    dob == null || joinedAt == null
            ) {
                JOptionPane.showMessageDialog(this, "Please fill all the input fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = new Student(name, email, address, password, grade, dob, phone, guardianName, gender, joinedAt);

                StudentService studentService = new StudentService();
                studentService.save(student);

                //show a success popup message
                JOptionPane.showMessageDialog(this, "Student has been added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                //reset the fields
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                addressField.setText("");
                gradeField.setText("");
                phoneField.setText("");
                guardianNameField.setText("");
                genderComboBox.setSelectedItem("");
                dobField.setText("");
                joinedAtField.setText("");
            }

        }
    }


}
