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
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_add_vacancy" />
    <input type="submit" value="${requestScope.addVacancy}"/>
</form>
<h3>${requestScope.vacancy}</h3>
<hr/>
<table border="1">
    <tr>
        <td>${requestScope.company}</td>
        <td>${requestScope.vacancy}</td>
        <td>${requestScope.salary}</td>
        <td>${requestScope.other}</td>
    </tr><tr>
    <c:forEach items="${requestScope.vacanciesList}" var="vacancy">

        <td>${vacancy.company}</td>
        <td>${vacancy.vacancy}</td>
        <td>${vacancy.salary}</td>
        <td>${vacancy.other}</td>
    <td>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="close_vacancy" />
            <input type="hidden" name="id" value="${vacancy.vacancyId}" />
            <input type="submit" value="${requestScope.closeVacancy}"/>
        </form>
    </td>
</tr>

    </c:forEach>
    ${emptyVacanciesList}
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="${requestScope.page}" />
    <input type="hidden" name="direction" value="prev" />
    <input type="submit" value="<<"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="${requestScope.page}" />
    <input type="hidden" name="direction" value="next" />
    <input type="submit" value=">>"/>
</form>
</body>
</html>