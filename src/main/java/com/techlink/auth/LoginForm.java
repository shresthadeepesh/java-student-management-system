/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.auth;

import com.techlink.students.StudentTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private final Container container;
    private final JButton login, register;
    private final JLabel emailLabel, passwordLabel, titleLabel;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JCheckBox remember;

    public LoginForm() {

        container = getContentPane();
        container.setLayout(null);

        titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
        container.add(titleLabel);

        emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(100, 100, 120, 30);
        container.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 100, 200, 30);
        container.add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 150, 120, 30);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 30);
        passwordField.setEchoChar('*');
        container.add(passwordField);

        remember = new JCheckBox("Remember me");
        remember.setContentAreaFilled(false);
        remember.setBounds(200, 200, 200, 30);
        container.add(remember);

        login = new JButton("Login");
        login.setBounds(200, 250, 120, 30);
        login.addActionListener(this);
        container.add(login);

        register = new JButton("Register");
        register.setBounds(200, 300, 120, 30);
        register.addActionListener(this);
        container.add(register);

        setLayout(null);
        setSize(500, 800);
        setTitle("Login");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register) {
            new RegisterForm();
        } else if(e.getSource() == login) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            boolean rememberMe = remember.isSelected();

            if(email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the input fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                AuthService authService = new AuthService();
                if(authService.authenticate(email, password)) {
                    JOptionPane.showMessageDialog(this, "You have successfully logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new StudentTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
