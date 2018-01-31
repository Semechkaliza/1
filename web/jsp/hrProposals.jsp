<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        ${requestScope.myProfile}
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_winners" />
    <input type="submit" value="${requestScope.winners}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="${requestScope.LogOut}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_profile" />
    <input type="submit" value="${requestScope.myProfile}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_vacancies_hr" />
    <input type="submit" value="${requestScope.vacancy}"/>
</form>
<table border="1">
    <tr>
        <td>${requestScope.name}</td>
        <td>${requestScope.sname}</td>
        <td>${requestScope.vacancyName}</td>
        <td>${requestScope.companyName}</td>
    </tr><tr>
    <c:forEach items="${requestScope.propList}" var="prop">

    <td>${prop.name}</td>
    <td>${prop.sname}</td>
    <td>${prop.vacancy}</td>
    <td>${prop.company}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_appoint_preview" />
        <input type="hidden" name="userId" value="${prop.userId}" />
        <input type="hidden" name="vacancyId" value="${prop.vacancyId}" />
        <input type="hidden" name="type" value="PREV" />
        <input type="submit" value="${requestScope.appoint}"/>
    </form></td>
</tr>
    </c:forEach>
</table>
</body>
</html>