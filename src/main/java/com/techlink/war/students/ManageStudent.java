/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.students;

import com.techlink.common.students.Student;
import com.techlink.common.students.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageStudent", value = {"/students"})
public class ManageStudent extends HttpServlet {

    private final StudentService studentService;

    public ManageStudent() {
        studentService = new StudentService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Student> students = studentService.all();

        request.setAttribute("students", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/students.jsp");
        requestDispatcher.forward(request, response);
    }

}
