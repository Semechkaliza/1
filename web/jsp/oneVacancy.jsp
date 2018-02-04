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
        <fmt:message key="vacancyName"/>
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
<hr/>
<table border="1">
    <tr>
        <td><fmt:message key="companyName"/></td>
        <td><fmt:message key="vacancyName"/></td>
        <td><fmt:message key="salary"/></td>
        <td><fmt:message key="other"/></td>
    </tr><tr>
    <td>${requestScope.oneVacancy.company}</td>
    <td>${requestScope.oneVacancy.vacancy}</td>
    <td>${requestScope.oneVacancy.salary}</td>
    <td>${requestScope.oneVacancy.other}</td>
    <td>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="add_proposal" />
            <input type="hidden" name="id" value=${requestScope.oneVacancy.vacancyId} />
            <input type="submit" value="<fmt:message key="addProposal"/>"/>
        </form>
    </td>

</tr>
</table>
</body>
</html>