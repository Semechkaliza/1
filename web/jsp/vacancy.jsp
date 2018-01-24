<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        ${requestScope.vacancy}
    </title>
</head>
<body>
<h3>${requestScope.vacancy}</h3>
<hr/>
<table border="1">
    <tr>
        <td>${requestScope.company}</td>
        <td>${requestScope.vacancy}</td>
        <td>${requestScope.salary}</td>
        <td>${requestScope.skill}</td>
        <td>${requestScope.other}</td>
        <td>${requestScope.active}</td>
    </tr><tr>
    <c:forEach items="${requestScope.vacanciesList}" var="vacancy">

        <td>${vacancy.company}</td>
        <td>${vacancy.vacancy}</td>
        <td>${vacancy.salary}</td>
        <td>${vacancy.skill}</td>
        <td>${vacancy.other}</td>
        <td>${vacancy.active}</td>
</tr>

    </c:forEach>
    ${emptyVacanciesList}
</table>

<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="${requestScope.LogOut}"/>
</form>
</body>
</html>