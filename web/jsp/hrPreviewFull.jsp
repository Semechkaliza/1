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
        <fmt:message key="previews"/>
    </title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_winners" />
        <label>
            <input type="submit" value="<fmt:message key="winners"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="logout" />
        <label>
            <input type="submit" value="<fmt:message key="LogOut"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_hr_profile" />
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
</header>
<table border="1">
    <tr>
        <td><fmt:message key="name"/></td>
        <td><fmt:message key="sname"/></td>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
        <td><fmt:message key="mark"/></td>
        <td><fmt:message key="feedback"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.prevList}" var="prev">

    <td>${prev.name}</td>
    <td>${prev.sname}</td>
    <td>${prev.vacancy}</td>
    <td>${prev.company}</td>
    <td>${prev.date}</td>
    <td>${prev.time}</td>
    <td>${prev.place}</td>
        <td>${prev.mark}</td>
        <td>${prev.feedback}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="close_interview" />
        <input type="hidden" name="userId" value="${prev.userId}" />
        <input type="hidden" name="vacancyId" value="${prev.vacancyId}" />
        <input type="hidden" name="type" value="PREV" />
        <input type="submit" class="button btnProfile" value="<fmt:message key="close"/>"/>
    </form></td>
        <td>  <form method="POST" action="controller">
            <input type="hidden" name="command" value="go_appoint_interview" />
            <input type="hidden" name="userId" value="${prev.userId}" />
            <input type="hidden" name="vacancyId" value="${prev.vacancyId}" />
            <input type="hidden" name="type" value="TECH" />
            <input type="submit" class="button btnProfile" value="<fmt:message key="appointTI"/>"/>
        </form></td>
        <td>  <form method="POST" action="controller">
            <input type="hidden" name="command" value="add_winner" />
            <input type="hidden" name="userId" value="${prev.userId}" />
            <input type="hidden" name="vacancyId" value="${prev.vacancyId}" />
            <input type="hidden" name="type" value="PREV" />
            <input type="submit" class="button btnProfile" value="<fmt:message key="addWinner"/>"/>
        </form></td>
</tr>
    </c:forEach>
</table>
</body>
</html>