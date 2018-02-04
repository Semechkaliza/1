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
        <fmt:message key="vacancy"/>
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
    <input type="hidden" name="direction" value="next" />
    <input type="submit" value="<fmt:message key="vacancy"/>"/>
</form>
<h3><fmt:message key="vacancy"/></h3>
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="vacancyName"/></td>
    </tr><tr>
    <c:forEach items="${requestScope.vacanciesList}" var="vacancy">

        <td>${vacancy.company}</td>
        <td>${vacancy.vacancy}</td>
        <td>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="one_vacancy" />
            <input type="hidden" name="id" value="${vacancy.vacancyId}" />
            <input type="submit" value="<fmt:message key="more"/>"/>
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