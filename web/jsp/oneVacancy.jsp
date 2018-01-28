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
    <input type="hidden" name="command" value="result" />
    <input type="submit" value="${requestScope.result}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="${requestScope.LogOut}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_my_profile" />
    <input type="submit" value="${requestScope.myProfile}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="submit" value="${requestScope.vacancy}"/>
</form>
<hr/>
<table border="1">
    <tr>
        <td>${requestScope.company}</td>
        <td>${requestScope.vacancy}</td>
        <td>${requestScope.salary}</td>
        <td>${requestScope.other}</td>
    </tr><tr>
    <td>${requestScope.oneVacancy.company}</td>
    <td>${requestScope.oneVacancy.vacancy}</td>
    <td>${requestScope.oneVacancy.salary}</td>
    <td>${requestScope.oneVacancy.other}</td>
    <td>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="add_proposal" />
            <input type="hidden" name="id" value=${requestScope.oneVacancy.vacancyId} />
            <input type="submit" value="${requestScope.addProposal}"/>
        </form>
    </td>

</tr>
</table>
</body>
</html>