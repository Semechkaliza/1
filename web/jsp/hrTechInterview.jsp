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
        <fmt:message key="techInterviews"/>
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
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="logout" />
        <label>
            <input type="submit" value="<fmt:message key="LogOut"/>"/>
        </label>
    </form>
</header>
<h3><fmt:message key="techInterviews"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="name"/></td>
        <td><fmt:message key="sname"/></td>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.prevList}" var="prev">

    <td>${prev.name}</td>
    <td>${prev.sname}</td>
    <td>${prev.vacancy}</td>
    <td>${prev.company}</td>
    <td>${prev.date}</td>
    <td>${prev.time}</td>
    <td>${prev.place}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_add_interview_result" />
        <input type="hidden" name="userId" value="${prev.userId}" />
        <input type="hidden" name="vacancyId" value="${prev.vacancyId}" />
        <input type="hidden" name="type" value="TECH" />
        <input type="submit" class="button btnProfile" value="<fmt:message key="appointTI"/>"/>
    </form></td>
</tr>
    </c:forEach>
</table>
<footer>
    <ex:Info/>
</footer>
</body>
</html>