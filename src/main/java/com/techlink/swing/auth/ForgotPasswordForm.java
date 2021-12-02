/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.auth;

import com.techlink.auth.AuthService;
import com.techlink.students.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class ForgotPasswordForm extends JFrame implements ActionListener {
    private final Container container;
    private final JButton submitButton;
    private final JLabel emailLabel, passwordLabel, confirmPasswordLabel, oldPasswordLabel, titleLabel;
    private final JTextField emailField;
    private final JPasswordField passwordField, confirmPasswordField, oldPasswordField;

    public ForgotPasswordForm() {

        container = getContentPane();

        titleLabel = new JLabel("Forgot password");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
        container.add(titleLabel);

        emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(100, 150, 120, 30);
        container.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 150, 200, 30);
        container.add(emailField);

        passwordLabel = new JLabel("Old Password");
        passwordLabel.setBounds(100, 200, 120, 30);
        container.add(passwordLabel);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(200, 200, 200, 30);
        oldPasswordField.setEchoChar('*');
        container.add(oldPasswordField);

        oldPasswordLabel = new JLabel("Password");
        oldPasswordLabel.setBounds(100, 250, 120, 30);
        container.add(oldPasswordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 250, 200, 30);
        passwordField.setEchoChar('*');
        container.add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(100, 300, 120, 30);
        container.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 300, 200, 30);
        confirmPasswordField.setEchoChar('*');
        container.add(confirmPasswordField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 400, 120, 30);
        submitButton.addActionListener(this);
        container.add(submitButton);

        setLayout(null);
        setSize(500, 800);
        setTitle("Forgot Password");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            String email = emailField.getText();
            String oldPassword = new String(oldPasswordField.getPassword());
            String newPassword = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            //checking if all the fields are filled
            if(email.isEmpty() || oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //checking if the password and confirm password are same
            else if(!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password does not match.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                AuthService authService = new AuthService();
                Optional<Student> student = authService.updatePassword(email, oldPassword, newPassword);
                if(student.isPresent()) {
                    JOptionPane.showMessageDialog(this, "Password has been changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email address or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }
}
