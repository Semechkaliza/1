<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>${requestScope.result}</title>
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
${requestScope.result}
${requestScope.PrevResults}
<hr/>
<table border="1">
    <tr>
        <td>${requestScope.company}</td>
        <td>${requestScope.vacancy}</td>
        <td>${requestScope.date}</td>
        <td>${requestScope.time}</td>
        <td>${requestScope.place}</td>
        <td>${requestScope.mark}</td>
        <td>${requestScope.feedback}</td>
    </tr><tr>
    <c:forEach items="${requestScope.resPrev}" var="prev">

        <td>${prev.company}</td>
        <td>${prev.vacancy}</td>
        <td>${prev.date}</td>
        <td>${prev.time}</td>
        <td>${prev.place}</td>
        <td>${prev.mark}</td>
        <td>${prev.feedback}</td>
</tr>

    </c:forEach>
</table>
${requestScope.TIResults}
<hr/>
<table border="1">
    <tr>
        <td>${requestScope.company}</td>
        <td>${requestScope.vacancy}</td>
        <td>${requestScope.date}</td>
        <td>${requestScope.time}</td>
        <td>${requestScope.place}</td>
        <td>${requestScope.mark}</td>
        <td>${requestScope.feedback}</td>
    </tr><tr>
    <c:forEach items="${requestScope.resTI}" var="TI">

    <td>${TI.company}</td>
    <td>${TI.vacancy}</td>
    <td>${TI.date}</td>
    <td>${TI.time}</td>
    <td>${TI.place}</td>
    <td>${TI.mark}</td>
    <td>${TI.feedback}</td>
</tr>

    </c:forEach>
</table>
</body>
</html>
