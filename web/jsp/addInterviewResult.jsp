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
    </tr><tr>

    <td>${requestScope.info.name}</td>
    <td>${requestScope.info.sname}</td>
    <td>${requestScope.info.vacancy}</td>
    <td>${requestScope.info.company}</td>
    <td>${requestScope.info.date}</td>
    <td>${requestScope.info.time}</td>
    <td>${requestScope.info.place}</td>

</tr>
</table><form method="POST" action="controller">
    <input type="hidden" name="command" value="add_interview_result" />
    <br/>${requestScope.mark}:<input type="number" name="mark" min="-1" max="10"/><br/>
    <br/>${requestScope.feedback}:<textarea name="feedback" value="" placeholder="feedback"></textarea><br/>
    ${requestScope.errorFormateMessage}
    <input type="hidden" name="userId" value="${requestScope.info.userId}" />
    <input type="hidden" name="vacancyId" value="${requestScope.info.vacancyId}" />
    <input type="hidden" name="type" value="${requestScope.info.type}" />
    <input type="submit" value="${requestScope.apply}"/>
</form>
</body>
</html>