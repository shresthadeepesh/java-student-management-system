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
import java.util.List;

@WebServlet(name = "ManageStudent", value = {"/students"})
public class ManageStudent extends BaseStudentServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if(session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        } else {
            List<Student> students = studentService.all();

            request.setAttribute("students", students);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/students.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));

            if(id > 0) {
                Student student = new Student();
                student.setId(id);
                Student deleteStudent = studentService.delete(student);

                if(deleteStudent != null) {
                    request.setAttribute("message", "Student has been deleted successfully");
                }
            }

            response.sendRedirect(request.getContextPath() + "/students");
        }
    }
}
