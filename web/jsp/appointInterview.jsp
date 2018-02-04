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
    <title><fmt:message key="appoint"/></title>
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

    <td>${requestScope.info.name}</td>
    <td>${requestScope.info.sname}</td>
    <td>${requestScope.info.vacancy}</td>
    <td>${requestScope.info.company}</td>
</tr>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="add_interview" />
    <br/><fmt:message key="date"/>:<input type="text" name="date" value="" placeholder="<fmt:message key="dateFormat"/>"/><br/>
    <br/><fmt:message key="time"/>:<input type="text" name="time" value="" placeholder="<fmt:message key="timeFormat"/>"/><br/>
    <br/><fmt:message key="place"/>:<input type="text" name="place" value=""/><br/>
    ${requestScope.errorFormateMessage}
    <input type="hidden" name="userId" value="${requestScope.info.userId}" />
    <input type="hidden" name="vacancyId" value="${requestScope.info.vacancyId}" />
    <input type="hidden" name="type" value="${requestScope.info.type}" />
    <input type="submit" value="<fmt:message key="appoint"/>"/>
    ${requestScope.errorParse}
</form>
</body>
</html>
