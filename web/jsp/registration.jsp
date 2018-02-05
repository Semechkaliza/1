<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <title>
        <fmt:message key="registration"/>
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
            <fmt:message key="registration"/>
            <input type="hidden" name="command" value="registration" />
                    <input type="text" name="login" value="" placeholder="<fmt:message key="login"/>"/><br/>
                   <input type="password" name="password" value="" placeholder="<fmt:message key="password"/>"/><br/>
                 <input type="password" placeholder="<fmt:message key="password"/>"/><br/>
                  <input type="text" name="email" value="" placeholder="<fmt:message key="email"/>"/><br/>
                <input type="text" name="phone" value="" placeholder="<fmt:message key="phone"/>"/><br>
            <input type="text" name="name" value="" placeholder="<fmt:message key="name"/>"/><br/>
            <input type="text" name="sname" value="" placeholder="<fmt:message key="sname"/>"/><br/>
          ${errorLoginPassMessage}
            <input type="submit" value="<fmt:message key="registration"/>"/>
</form>
</body>
</html>