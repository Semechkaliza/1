<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>
        Login
    </title>
</head>
<body>
<form method="POST" action="controller">
 <input type="hidden" value="locale"/>
    <label>
    <input name="locale" type="radio" value="ru">
    </label> RU
    <label>
        <input name="locale" type="radio" value="en">
    </label> EN
    <label>
        <input name="locale" type="radio" value="be" checked>
    </label> BE
    <br>
    <input type="hidden" name="command" value="login" />${requestScope.login}:<br/>
    <input type="text" name="login" value=""/><br/>${requestScope.password}:<br/>
    <input type="password" name="password" value=""/><br/>
    ${errorLoginPassMessage} <br/>
    ${wrongAction} <br/>
    ${nullPage} <br/>
    <input type="submit" value="${requestScope.LogIn}"/>
</form>
<form method="GET" action="controller">
    <input type="hidden" name="action" value="registration" />
    <input type="submit" value="${requestScope.registration}"/>
</form>
<hr/>
</body>
</html>