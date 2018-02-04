<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <title>
        <fmt:message key="login"/>
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
    <input type="hidden" name="command" value="login" /><fmt:message key="login"/>:<br/>
    <input type="text" name="login" value=""/><br/><fmt:message key="password"/>:<br/>
    <input type="password" name="password" value=""/><br/>
    ${errorLoginPassMessage} <br/>
    ${wrongAction} <br/>
    ${nullPage} <br/>
    <input type="submit" value="<fmt:message key="LogIn"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_registration" />
    <input type="submit" value="<fmt:message key="registration"/>"/>
</form>
<hr/>
</body>
</html>