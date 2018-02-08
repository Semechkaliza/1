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
    <title><fmt:message key="result"/></title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="result" />
        <label>
            <input type="submit" value="<fmt:message key="result"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_my_profile" />
        <label>
            <input type="submit" value="<fmt:message key="myProfile"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies" />
        <input type="hidden" name="page" value="1" />
        <input type="hidden" name="direction" value="" />
        <label>
            <input type="submit" value="<fmt:message key="vacancy"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="logout" />
        <label>
            <input type="submit" value="<fmt:message key="LogOut"/>"/>
        </label>
    </form>
</header>
<h3><fmt:message key="PrevResults"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
        <td><fmt:message key="mark"/></td>
        <td><fmt:message key="feedback"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.resPrev}" var="prev">

        <td>${prev.company}</td>
        <td>${prev.vacancy}</td>
        <td>${prev.date}</td>
        <td>${prev.time}</td>
        <td>${prev.place}</td>
        <td>${prev.mark}</td>
        <td>${prev.feedback}</td>
</tr>

    </c:forEach>
</table>
<h3><fmt:message key="TIResults"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
        <td><fmt:message key="mark"/></td>
        <td><fmt:message key="feedback"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.resTI}" var="TI">

    <td>${TI.company}</td>
    <td>${TI.vacancy}</td>
    <td>${TI.date}</td>
    <td>${TI.time}</td>
    <td>${TI.place}</td>
    <td>${TI.mark}</td>
    <td>${TI.feedback}</td>
</tr>

    </c:forEach>
</table>
</body>
</html>
