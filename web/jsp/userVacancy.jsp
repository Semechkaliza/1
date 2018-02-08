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
        <fmt:message key="vacancy"/>
    </title>
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
<h3><fmt:message key="vacancy"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="vacancyName"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.vacanciesList}" var="vacancy">

        <td>${vacancy.company}</td>
        <td>${vacancy.vacancy}</td>
        <td>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="one_vacancy" />
            <input type="hidden" name="id" value="${vacancy.vacancyId}" />
            <input type="submit" class="button btnProfile" value="<fmt:message key="more"/>"/>
        </form>
    </td>
</tr>

    </c:forEach>
    ${emptyVacanciesList}
</table>
<section class="btnLeftRight">
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies" />
        <input type="hidden" name="page" value="${requestScope.page}" />
        <input type="hidden" name="direction" value="prev" />
        <input type="submit" class="button" value="<<"/>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies" />
        <input type="hidden" name="page" value="${requestScope.page}" />
        <input type="hidden" name="direction" value="next" />
        <input type="submit" class="button" value=">>"/>
    </form>
</section>
</body>
</html>