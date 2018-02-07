<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <title>
        <fmt:message key="myProfile"/>
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="result" />
    <input type="submit" value="<fmt:message key="result"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="<fmt:message key="LogOut"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_my_profile" />
    <input type="submit" value="<fmt:message key="myProfile"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="direction" value="" />
    <input type="submit" value="<fmt:message key="vacancy"/>"/>
</form>
<table border="1">
    <tr>
        <td><fmt:message key="login"/></td>
        <td><fmt:message key="name"/></td>
        <td><fmt:message key="sname"/></td>
    </tr><tr>
    <td>${requestScope.user.login}</td>
    <td>${requestScope.user.name}</td>
    <td>${requestScope.user.sname}</td>
</tr>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_change_info" />
    <input type="submit" value="<fmt:message key="changeInfo"/>"/>
</form>
<fmt:message key="myProposal"/>
<table border="1">
    <tr>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.proposalList}" var="prop">

    <td>${prop.vacancy}</td>
    <td>${prop.company}</td>
    <td>  <form method="POST" action="controller">
        <input type="hidden" name="command" value="cancel_proposal" />
        <input type="hidden" name="id" value="${prop.id}" />
        <input type="submit" value="<fmt:message key="cancel"/>"/>
    </form></td>
</tr>
    </c:forEach>
</table>
${requestScope.errorAddProposal}
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="direction" value="" />
    <input type="submit" value="<fmt:message key="addProposal"/>"/>
</form>
<fmt:message key="futurePreview"/>
<table border="1">
    <tr>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.previewList}" var="prev">

    <td>${prev.vacancy}</td>
    <td>${prev.company}</td>
        <td>${prev.dateStr}</td>
        <td>${prev.timeStr}</td>
        <td>${prev.place}</td>
</tr>
    </c:forEach>
</table>
<fmt:message key="futureTechInterview"/>
<table border="1">
    <tr>

        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="date"/></td>
        <td><fmt:message key="time"/></td>
        <td><fmt:message key="place"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.techList}" var="tech">

        <td>${tech.vacancy}</td>
        <td>${tech.company}</td>
        <td>${tech.date}</td>
        <td>${tech.time}</td>
        <td>${tech.place}</td>
        </tr>
    </c:forEach>
</table>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="delete_user" />
    <input type="submit" value="<fmt:message key="deleteProfile"/>"/>
</form>
</body>
</html>