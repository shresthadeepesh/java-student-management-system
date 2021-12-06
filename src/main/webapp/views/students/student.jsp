<%--
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
    <title>View Student</title>
</head>
<body>

    <h2>View Student</h2>
    <div class="">
        <p class="">Name: ${student.getName()}</p>
        <p class="">Address: ${student.getAddress()}</p>
        <p class="">Phone: ${student.getPhone()}</p>
        <p class="">Guardian Name: ${student.getGuardianName()}</p>
        <p class="">Date of Birth: ${student.getDob()}</p>
        <p class="">Grade: ${student.getGrade()}</p>
        <p class="">Joined At: ${student.getJoinedAt()}</p>
        <p class="">Email Address: ${student.getEmail()}</p>
        <a href="${pageContext.request.contextPath}/students/edit?id=${student.getId()}">Edit</a>
        <form action="${pageContext.request.contextPath}/students" method="POST">
            <input type="hidden" name="id" value="${student.getId()}"/>
            <input type="submit" value="Delete"/>
        </form>
    </div>

</body>
</html>
