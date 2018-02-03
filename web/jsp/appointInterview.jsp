<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>${requestScope.previews}</title>
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

    <td>${requestScope.info.name}</td>
    <td>${requestScope.info.sname}</td>
    <td>${requestScope.info.vacancy}</td>
    <td>${requestScope.info.company}</td>
</tr>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="add_interview" />
    <br/>${requestScope.date}:<input type="text" name="date" value="" placeholder="${requestScope.dateFormat}"/><br/>
    <br/>${requestScope.time}:<input type="text" name="time" value="" placeholder="${requestScope.timeFormat}"/><br/>
    <br/>${requestScope.place}:<input type="text" name="place" value=""/><br/>
    ${requestScope.errorFormateMessage}
    <input type="hidden" name="userId" value="${requestScope.info.userId}" />
    <input type="hidden" name="vacancyId" value="${requestScope.info.vacancyId}" />
    <input type="hidden" name="type" value="${requestScope.info.type}" />
    <input type="submit" value="${requestScope.appoint}"/>
    ${requestScope.errorParse}
</form>
</body>
</html>
