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
    <title>Register</title>
</head>
<body>
<h2>Register</h2>

<h3 class=""><% request.getAttribute("errors"); %></h3>

<form action="register" method="POST">
    <div>
        <%--@declare id="name"--%>
        <label for="name">Full Name</label>
        <input type="text" name="name" />
    </div>
    <div>
        <%--@declare id="email"--%>
        <label for="email">Email Address</label>
        <input type="email" name="email" />
    </div>
    <div>
        <%--@declare id="password"--%>
        <label for="password">Password</label>
        <input type="password" name="password" />
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
