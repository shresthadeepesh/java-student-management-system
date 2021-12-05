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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@WebServlet(name = "EditStudent", urlPatterns = {"/students/edit"})
public class EditStudent extends BaseStudentServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if(session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));

            Optional<Student> student = studentService.show(id);

            if(student.isPresent()) {
                request.setAttribute("student", student.get());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/students/edit.jsp");
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/students");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String grade = request.getParameter("grade");
            String gender = request.getParameter("gender");
            LocalDate dob = LocalDate.parse(request.getParameter("dob"));
            String phone = request.getParameter("phone");
            String guardianName = request.getParameter("guardian_name");
            LocalDate joinedAt = LocalDate.parse(request.getParameter("joined_at"));
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm_password");

            //converting to java.util.Date
            Date parsedDob = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date parsedJoinedAt = Date.from(joinedAt.atStartOfDay(ZoneId.systemDefault()).toInstant());

            if (!name.isEmpty() && !address.isEmpty() && !grade.isEmpty() && !phone.isEmpty() && !guardianName.isEmpty() && !joinedAt.toString().isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
                if (!password.equals(confirmPassword)) {
                    request.setAttribute("error", "Password and Confirm Password does not match");
                } else {
                    Student student = new Student(name, email, password, address, grade, parsedDob, phone, guardianName, gender, parsedJoinedAt);
                    Student newStudent = studentService.update(id, student);

                    if (newStudent != null) {
                        response.sendRedirect(request.getContextPath() + "/students");
                    }
                }
            } else {
                request.setAttribute("error", "Validation Error. Please fill all the fields");
                response.sendRedirect(request.getContextPath() + "/students/edit?id=" + id);
            }
        }
    }
}
