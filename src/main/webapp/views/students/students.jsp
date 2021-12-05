<%@ page import="com.techlink.common.students.Student" %>
<%@ page import="java.util.List" %><%--
  ~ Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
  ~ Github: https://github.com/JustaNormalDreamer
  --%>

<%--
  Created by IntelliJ IDEA.
  User: dipes
  Date: 12/5/2021
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Student</title>
</head>
<body>

<h2>Manage Student</h2>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Grade</td>
        <td>Age</td>
        <td>Joined At</td>
    </tr>
    </thead>
    <tbody>

    <% List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student: students) {
    %>

    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td></td>
        <td></td>
    </tr>

    <% } %>
    </tbody>
</table>

</body>
</html>
