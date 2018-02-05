<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <title><fmt:message key="changeInfo"/></title>
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
<fmt:message key="name"/>
<form method="POST" action="controller">
<input type="hidden" name="command" value="change_info"/>
<input type="text" name="name" value=""/><br/>
    <fmt:message key="sname"/>
<input type="text" name="sname" value=""/><br/>
    <fmt:message key="phone"/>
<input type="text" name="phone" value=""/><br/>
    <fmt:message key="email"/>
<input type="text" name="email" value=""/><br/>
<input type="submit" value="<fmt:message key="apply"/>"/>
</form>
</body>
</html>
