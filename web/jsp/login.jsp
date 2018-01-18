<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>
        Login
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="login" />Login:<br/>
    <input type="text" name="login" value=""/><br/>Password:<br/>
    <input type="password" name="password" value=""/><br/>
    ${errorLoginPassMessage} <br/>
    ${wrongAction} <br/>
    ${nullPage} <br/>
    <input type="submit" value="Log in"/>
    <a href="/jsp/registration.jsp">Registration</a>
</form>
<hr/>
</body>
</html>