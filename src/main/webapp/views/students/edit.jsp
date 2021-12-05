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
    <title>Edit Student</title>
</head>
<body>
<h2>Edit Student</h2>
<h3 class=""><% request.getAttribute("errors"); %></h3>

<form action="edit?id=${student.getId()}" method="POST">
    <div>
        <%--@declare id="name"--%>
        <label for="name">Full Name</label>
        <input type="text" name="name" value="${student.getName()}" />
    </div>
    <div>
        <%--@declare id="address"--%>
        <label for="address">Address</label>
        <input type="text" name="address" value="${student.getEmail()}" />
    </div>
    <div>
        <%--@declare id="grade"--%>
        <label for="grade">Grade</label>
        <input type="text" name="grade" value="${student.getGrade()}" />
    </div>
    <div>
        <%--@declare id="dob"--%>
        <label for="dob">Date of birth</label>
        <input type="date" name="dob" value="${student.getDob()}" />
    </div>
    <div>
        <%--@declare id="phone"--%>
        <label for="phone">Phone</label>
        <input type="text" name="phone" value="${student.getPhone()}" />
    </div>
    <div>
        <%--@declare id="guardian_name"--%>
        <label for="guardian_name">Guardian Name</label>
        <input type="text" name="guardian_name" value="${student.getGuardianName()}" />
    </div>
    <div>
        <%--@declare id="gender"--%>
        <label for="gender">Gender</label>
        <select name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Others">Others</option>
        </select>
    </div>
    <div>
        <%--@declare id="joined_at"--%>
        <label for="joined_at">Joined At</label>
        <input type="date" name="joined_at" value="${student.getJoinedAt()}" />
    </div>
    <div>
        <%--@declare id="email"--%>
        <label for="email">Email Address</label>
        <input type="email" name="email" value="${student.getEmail()}" />
    </div>
    <div>
        <%--@declare id="password"--%>
        <label for="name">Password</label>
        <input type="password" name="password" />
    </div>
    <div>
        <%--@declare id="confirm_password"--%>
        <label for="name">Confirm Password</label>
        <input type="password" name="confirm_password" />
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
