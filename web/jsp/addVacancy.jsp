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
        <fmt:message key="addVacancy"/>
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_winners" />
    <input type="submit" value="<fmt:message key="winners"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="logout" />
    <input type="submit" value="<fmt:message key="LogOut"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_profile" />
    <input type="submit" value="<fmt:message key="myProfile"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="get_vacancies" />
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="direction" value="" />
    <input type="submit" value="<fmt:message key="vacancy"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="add_vacancy" />
    <br/><fmt:message key="vacancyName"/>:<input type="text" name="vacancy"/><br/>
    <br/><fmt:message key="companyName"/>:<input type="text" name="company"/><br/>
    <br/><fmt:message key="salary"/>:<input type="text" name="salary"/><br/>
    <br/><fmt:message key="other"/>:<textarea name="other"></textarea><br/>
    ${requestScope.emptyVacancy}
    <input type="submit" value="<fmt:message key="addVacancy"/>"/>
</form>
</body>
</html>