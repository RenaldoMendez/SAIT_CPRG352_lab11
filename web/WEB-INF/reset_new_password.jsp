<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        <form action="reset" method="post">
        <input type="text" name="new_password" value="">
        <input type="hidden" name="uuid" value="${user_uuid}">
        <input type="hidden" name="action" value="set_password">
        <input type="submit" value="Submit">
        </form>
        <p>${message}</p>
    </body>
</html>
