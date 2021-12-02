/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.home;

import com.techlink.swing.auth.LoginForm;
import com.techlink.swing.students.StudentTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame implements ActionListener {

    private final JLabel titleLabel, authLabel;
    private final Container container;
    private final JButton studentButton, logoutButton;

    public HomeScreen(String email) {

        container = getContentPane();

        titleLabel = new JLabel("Welcome to Student Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(50, 50, 400, 30);
        container.add(titleLabel);

        authLabel = new JLabel(email);
        authLabel.setFont(new Font("Arial", Font.BOLD, 10));
        authLabel.setBounds(300, 100, 400, 30);
        container.add(authLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(300, 150, 100, 15);
        logoutButton.addActionListener(this);
        container.add(logoutButton);

        studentButton = new JButton("Students");
        studentButton.setBounds(100, 200, 80, 20);
        studentButton.addActionListener(this);
        container.add(studentButton);

        setLayout(null);
        setSize(500, 800);
        setTitle("Home");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (studentButton.equals(e.getSource())) {
            new StudentTable();
        } else if(logoutButton.equals(e.getSource())) {
             new LoginForm();
             JOptionPane.showMessageDialog(null, "You have been logged out!", "Success", JOptionPane.INFORMATION_MESSAGE);
             dispose();
         }
    }
}
