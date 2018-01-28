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
<hr/>
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
        <td>${requestScope.login}</td>
        <td>${requestScope.name}</td>
        <td>${requestScope.sname}</td>
        <td>${requestScope.role}</td>
    </tr><tr>
    <c:forEach items="${requestScope.user}" var="users">

    <td>${users.login}</td>
    <td>${users.name}</td>
    <td>${users.sname}</td>
    <td>${users.role}</td>
</tr>
    </c:forEach>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_proposals" />
    <input type="submit" value="${requestScope.proposals}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_previews" />
    <input type="submit" value="${requestScope.previews}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_tech_interviews" />
    <input type="submit" value="${requestScope.techInterviews}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_change_info" />
    <input type="submit" value="${requestScope.changeInfo}"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="delete_user" />
    <input type="submit" value="${requestScope.deleteProfile}"/>
</form>
</body>
</html>