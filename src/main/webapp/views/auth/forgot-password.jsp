<%--
  ~ Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
  ~ Github: https://github.com/JustaNormalDreamer
  --%>

<%--
  Created by IntelliJ IDEA.
  User: dipes
  Date: 12/5/2021
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
</head>
<body>

<h2>Forgot Password</h2>

<h3 class=""><% request.getAttribute("errors"); %></h3>

<form action="forgot-password" method="POST">
    <div>
        <%--@declare id="email"--%>
        <label for="email">Email Address</label>
        <input type="email" name="email" />
    </div>
    <div>
        <%--@declare id="old_password"--%>
        <label for="old_password">Old Password</label>
        <input type="password" name="old_password" />
    </div>

    <div>
        <%--@declare id="new_password"--%>
        <label for="new_password">New Password</label>
        <input type="password" name="new_password" />
    </div>

    <div>
        <%--@declare id="confirm_password"--%>
        <label for="confirm_password">Confirm Password</label>
        <input type="password" name="confirm_password" />
    </div>
    <input type="submit" value="Submit">
</form>

</body>
</html>
