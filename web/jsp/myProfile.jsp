<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        ${requestScope.main}
    </title>
</head>
<body>
<h3>${requestScope.welcome}</h3>
<hr/>
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
<table border="1">
    <tr>
        <td>${requestScope.login}</td>
        <td>${requestScope.name}</td>
        <td>${requestScope.sname}</td>
        <td>${requestScope.role}</td>
        <td>${requestScope.rating}</td>
    </tr><tr>
    <c:forEach items="${requestScope.user}" var="users">

    <td>${users.login}</td>
    <td>${users.name}</td>
    <td>${users.sname}</td>
    <td>${users.role}</td>
    <td>${users.rating}</td>
</tr>
    </c:forEach>
</table>
${requestScope.myProposal}
<table border="1">
    <tr>
        <td>${requestScope.login}</td>
        <td>${requestScope.vacancyName}</td>
        <td>${requestScope.companyName}</td>
    </tr><tr>
    <c:forEach items="${requestScope.proposalList}" var="prop">

    <td>${prop.login}</td>
    <td>${prop.vacancy}</td>
    <td>${prop.company}</td>
</tr>
    </c:forEach>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="submit" value="${requestScope.addProposal}"/>
</form>
</body>
</html>