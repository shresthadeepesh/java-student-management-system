/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.students;

import com.techlink.common.students.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ViewStudent", value = {"/students/view"})
public class ViewStudent extends BaseStudentServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if(session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));

            if(id != 0) {
                Optional<Student> student = studentService.show(id);
                if(student.isPresent()) {
                    request.setAttribute("student", student.get());

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/student.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/students");
            }
        }
    }
}
