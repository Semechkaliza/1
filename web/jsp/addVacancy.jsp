<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld"%>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>
        <fmt:message key="addVacancy"/>
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
<h3><fmt:message key="addVacancy"/></h3>
<hr/>
<form method="POST" class="addVacancy" action="controller">
    <input type="hidden" name="command" value="add_vacancy" />
    <fmt:message key="vacancyName"/>:<input class="inputForm" type="text" name="vacancy"/>
    <fmt:message key="companyName"/>:<input class="inputForm" type="text" name="company"/>
    <fmt:message key="salary"/>:<input class="inputForm" type="text" name="salary"/>
    <fmt:message key="other"/>:<textarea class="inputForm" name="other"></textarea>
    ${requestScope.emptyVacancy}
    <input type="submit" class="button addV" value="<fmt:message key="addVacancy"/>"/>
</form>
<footer>
    <ex:Info/>
</footer>
</body>
</html>