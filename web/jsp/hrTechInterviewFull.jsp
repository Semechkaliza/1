<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        ${requestScope.previews}
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
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="direction" value="" />
    <input type="submit" value="${requestScope.vacancy}"/>
</form>
<table border="1">
    <tr>
        <td>${requestScope.name}</td>
        <td>${requestScope.sname}</td>
        <td>${requestScope.vacancyName}</td>
        <td>${requestScope.companyName}</td>
        <td>${requestScope.date}</td>
        <td>${requestScope.time}</td>
        <td>${requestScope.place}</td>
        <td>${requestScope.mark}</td>
        <td>${requestScope.feedback}</td>
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
        <input type="hidden" name="type" value="TECH" />
        <input type="submit" value="${requestScope.close}"/>
    </form></td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="add_winner" />
        <input type="hidden" name="userId" value="${prev.userId}" />
        <input type="hidden" name="vacancyId" value="${prev.vacancyId}" />
        <input type="hidden" name="type" value="TECH" />
        <input type="submit" value="${requestScope.addWinner}"/>
    </form></td>
</tr>
    </c:forEach>
</table>
</body>
</html>