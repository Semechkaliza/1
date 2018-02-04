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
        <fmt:message key="myProfile"/>
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_winners" />
    <input type="submit" value="<fmt:message key="winners"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="<fmt:message key="LogOut"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_profile" />
    <input type="submit" value="<fmt:message key="myProfile"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="direction" value="" />
    <input type="submit" value="<fmt:message key="vacancy"/>"/>
</form>
<table border="1">
    <tr>
        <td><fmt:message key="name"/></td>
        <td><fmt:message key="sname"/></td>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.propList}" var="prop">

    <td>${prop.name}</td>
    <td>${prop.sname}</td>
    <td>${prop.vacancy}</td>
    <td>${prop.company}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_appoint_interview" />
        <input type="hidden" name="userId" value="${prop.userId}" />
        <input type="hidden" name="vacancyId" value="${prop.vacancyId}" />
        <input type="hidden" name="type" value="PREV" />
        <input type="submit" value="<fmt:message key="appoint"/>"/>
    </form></td>
</tr>
    </c:forEach>
</table>
</body>
</html>