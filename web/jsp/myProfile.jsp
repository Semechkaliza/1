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
    <input type="hidden" name="command" value="go_change_info" />
    <input type="submit" value="${requestScope.changeInfo}"/>
</form>
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
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="cancel_proposal" />
        <input type="hidden" name="id" value="${prop.id}" />
        <input type="submit" value="${requestScope.cancel}"/>
    </form></td>
</tr>
    </c:forEach>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="submit" value="${requestScope.addProposal}"/>
</form>
${requestScope.futurePreview}
<table border="1">
    <tr>
        <td>${requestScope.login}</td>
        <td>${requestScope.vacancyName}</td>
        <td>${requestScope.companyName}</td>
        <td>${requestScope.date}</td>
        <td>${requestScope.time}</td>
        <td>${requestScope.place}</td>
    </tr><tr>
    <c:forEach items="${requestScope.previewList}" var="prev">

    <td>${prev.login}</td>
    <td>${prev.vacancy}</td>
    <td>${prev.company}</td>
        <td>${prev.date}</td>
        <td>${prev.time}</td>
        <td>${prev.place}</td>
</tr>
    </c:forEach>
</table>
${requestScope.futureTechInterview}
<table border="1">
    <tr>
        <td>${requestScope.login}</td>
        <td>${requestScope.vacancyName}</td>
        <td>${requestScope.companyName}</td>
        <td>${requestScope.date}</td>
        <td>${requestScope.time}</td>
        <td>${requestScope.place}</td>
    </tr><tr>
    <c:forEach items="${requestScope.techList}" var="tech">

        <td>${tech.login}</td>
        <td>${tech.vacancy}</td>
        <td>${tech.company}</td>
        <td>${tech.date}</td>
        <td>${tech.time}</td>
        <td>${tech.place}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>