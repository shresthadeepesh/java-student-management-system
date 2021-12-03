/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.auth;

import com.techlink.common.auth.AuthService;
import com.techlink.common.students.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame implements ActionListener {
    private final Container container;
    private final JButton login, register;
    private final JLabel emailLabel, passwordLabel, confirmPasswordLabel, nameLabel, titleLabel;
    private final JTextField emailField, nameField;
    private final JPasswordField passwordField, confirmPasswordField;
    private final JCheckBox accept;

    public RegisterForm() {
        
        container = getContentPane();

        titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
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

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 250, 120, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 250, 200, 30);
        passwordField.setEchoChar('*');
        container.add(passwordField);

        confirmPasswordLabel = new JLabel("Password");
        confirmPasswordLabel.setBounds(100, 300, 120, 30);
        container.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 300, 200, 30);
        confirmPasswordField.setEchoChar('*');
        container.add(confirmPasswordField);

        accept = new JCheckBox("I accept the terms & policy.");
        accept.setContentAreaFilled(false);
        accept.setBounds(200, 350, 250, 30);
        container.add(accept);

        register = new JButton("Register");
        register.setBounds(200, 400, 120, 30);
        register.addActionListener(this);
        container.add(register);

        login = new JButton("Login");
        login.setBounds(200, 450, 120, 30);
        login.addActionListener(this);
        container.add(login);

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
        if(e.getSource() == register) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password does not match.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                AuthService authService = new AuthService();
                Student student = authService.register(name, email, password);
                if(student != null) {
                    JOptionPane.showMessageDialog(this, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginForm();
                }
            }

        } else if(e.getSource() == login) {
            dispose();
            new LoginForm();
        }
    }
}
