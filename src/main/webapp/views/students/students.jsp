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
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    td {
        border: 1px solid black;
        padding: 5px;
    }
</style>
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
        <td>Actions</td>
    </tr>
    </thead>
    <tbody>

    <% List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student: students) {
    %>

    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getGrade() %></td>
        <td><%= student.getDob() %></td>
        <td><%= student.getJoinedAt() %></td>
        <td>
            <a href="students/edit?id=<%= student.getId() %>">Edit</a>
            <form action="students" method="POST">
                <input type="hidden" name="id" value="<%= student.getId() %>"/>
                <input type="submit" value="Delete"/>
            </form>
        </td>
    </tr>

    <% } %>
    </tbody>
</table>

</body>
</html>
