<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot My Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <form action="reset" method="post">
        <p>Please enter your email address to reset your password.</p><br>
        <label>Email address:</label>
        <input type="text" name="user_email" value="">
        <input type="hidden" name="action" value="send_email">
        <input type="submit" value="Send">
        <p>${message}</p>
    </form>
    </body>
</html>
