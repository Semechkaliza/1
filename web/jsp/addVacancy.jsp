<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        ${requestScope.addVacancy}
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
<form method="POST" action="controller">
    <input type="hidden" name="command" value="add_vacancy" />
    <br/>${requestScope.vacancyName}:<input type="text" name="vacancy"/><br/>
    <br/>${requestScope.companyName}:<input type="text" name="company"/><br/>
    <br/>${requestScope.salary}:<input type="text" name="salary"/><br/>
    <br/>${requestScope.other}:<textarea name="other"></textarea><br/>
    ${requestScope.errorFormateMessage}
    <input type="submit" value="${requestScope.addVacancy}"/>
</form>
</body>
</html>