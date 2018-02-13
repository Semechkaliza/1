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
        <fmt:message key="winners"/>
    </title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <form method="POST" action="controller">
        <div class="logo">
            <h3>HR-system</h3>
        </div>
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
<h3><fmt:message key="approved"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="name"/></td>
        <td><fmt:message key="sname"/></td>
        <td><fmt:message key="phone"/></td>
        <td><fmt:message key="email"/></td>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.winList}" var="win">

        <td>${win.name}</td>
        <td>${win.sname}</td>
        <td>${win.phone}</td>
        <td>${win.email}</td>
        <td>${win.vacancy}</td>
        <td>${win.company}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="handle_winner" />
        <input type="hidden" name="user" value="${win.userId}" />
        <input type="hidden" name="vacancy" value="${win.vacancyId}" />
        <input type="submit" class="button btnProfile" value="<fmt:message key="close"/>"/>
    </form></td>
</tr>
    </c:forEach>
</table>
<footer>
    <h4><ex:Info/></h4>
</footer>
</body>
</html>