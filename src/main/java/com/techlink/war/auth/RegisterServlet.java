/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.auth;

import com.techlink.common.auth.AuthService;
import com.techlink.common.students.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = {"/auth/register"})
public class RegisterServlet extends HttpServlet {
    private final AuthService authService;

    public RegisterServlet() {
        authService = new AuthService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            Student student = authService.register(name, email, password);
            if(student != null) {
                response.sendRedirect(request.getContextPath() + "/auth/login");
            }
        } else {
            request.setAttribute("errors", "Please fill all the fields");
            response.sendRedirect(request.getContextPath() + "/auth/register");
        }
    }
}
