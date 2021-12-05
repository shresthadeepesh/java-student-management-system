/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.students;

import com.techlink.common.students.StudentService;

import javax.servlet.http.HttpServlet;

public abstract class BaseStudentServlet extends HttpServlet {

    protected final StudentService studentService;

    public BaseStudentServlet() {
        this.studentService = new StudentService();
    }
}
