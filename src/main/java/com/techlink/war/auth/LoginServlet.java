/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.auth;

import com.techlink.common.auth.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/auth/login"})
public class LoginServlet extends HttpServlet {

    private final AuthService authService;

    public LoginServlet() {
        authService = new AuthService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email != null && password != null && authService.authenticate(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            response.sendRedirect(request.getContextPath() + "/");
        } else {
            request.setAttribute("errors", "Invalid email or password");
            response.sendRedirect(request.getContextPath() + "/auth/login");
        }
    }
}
