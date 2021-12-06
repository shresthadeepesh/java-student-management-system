<%--
  ~ Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
  ~ Github: https://github.com/JustaNormalDreamer
  --%>

<%--
  Created by IntelliJ IDEA.
  User: dipes
  Date: 12/5/2021
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Home</h2>
    <p>Welcome to the home page</p>
    <% if(request.getSession().getAttribute("email") != null) { %>
        <a href="${pageContext.request.contextPath}/students">Manage Student</a>
        <a href="${pageContext.request.contextPath}/students/add">Add Student</a>
    <%  } else { %>
        <a href="${pageContext.request.contextPath}/auth/login">Login</a>
        <a href="${pageContext.request.contextPath}/auth/register">Register</a>
    <% }  %>



</body>
</html>
