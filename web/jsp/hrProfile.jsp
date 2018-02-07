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
<hr/>
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
    <input type="hidden" name="command" value="go_hr_proposals" />
    <input type="submit" value="<fmt:message key="proposals"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_previews" />
    <input type="submit" value="<fmt:message key="previews"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_previews_full" />
    <input type="submit" value="<fmt:message key="fullPreview"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_tech_interviews" />
    <input type="submit" value="<fmt:message key="techInterviews"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_hr_tech_interviews_full" />
    <input type="submit" value="<fmt:message key="fullTI"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="add_admin" />
    <br/><fmt:message key="login"/> :<input type="text" name="login"/><br/>
    <input type="submit" value="<fmt:message key="addAdmin"/>"/>
</form>
${requestScope.errorMessage}
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_change_info" />
    <input type="submit" value="<fmt:message key="changeInfo"/>"/>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="delete_user" />
    <input type="submit" value="<fmt:message key="deleteProfile"/>"/>
</form>
</body>
</html>