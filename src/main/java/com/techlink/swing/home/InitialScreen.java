/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.home;

import com.techlink.swing.auth.LoginForm;
import com.techlink.swing.auth.RegisterForm;
import com.techlink.swing.students.StudentTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialScreen extends JFrame implements ActionListener {

    private final JLabel titleLabel;
    private final Container container;
    private final JButton loginButton, registerButton;

    public InitialScreen() {

        container = getContentPane();

        titleLabel = new JLabel("Welcome to Student Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(50, 50, 400, 30);
        container.add(titleLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 100, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(200, 100, 100, 30);
        registerButton.addActionListener(this);
        container.add(registerButton);

        setLayout(null);
        setSize(500, 800);
        setTitle("Student Management System");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (loginButton.equals(e.getSource())) {
            new LoginForm();
        } else if (registerButton.equals(e.getSource())) {
            new RegisterForm();
        }
        dispose();
    }
}
