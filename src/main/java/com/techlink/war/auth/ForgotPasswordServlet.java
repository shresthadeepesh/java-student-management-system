/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.auth;

import com.techlink.common.students.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ForgotPasswordServlet", value = {"/auth/forgot-password"})
public class ForgotPasswordServlet extends BaseAuthServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/forgot-password.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        if(!email.isEmpty() && !oldPassword.isEmpty() && !newPassword.isEmpty() && !confirmPassword.isEmpty()){
            if(newPassword.equals(confirmPassword)) {
                Optional<Student> student = authService.updatePassword(email, oldPassword, newPassword);
                if(student.isEmpty()) {
                    request.setAttribute("error", "User doesn't exist.");
                } else {
                    response.sendRedirect(request.getContextPath() + "/auth/login");
                }
            }
        } else {
            request.setAttribute("error", "Please fill all the fields.");
            response.sendRedirect(request.getContextPath() + "/auth/forgot-password");
        }
    }
}
