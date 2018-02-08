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
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_winners" />
        <label>
            <input type="submit" value="<fmt:message key="winners"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="logout" />
        <label>
            <input type="submit" value="<fmt:message key="LogOut"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_hr_profile" />
        <label>
            <input type="submit" value="<fmt:message key="myProfile"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies" />
        <input type="hidden" name="page" value="1" />
        <input type="hidden" name="direction" value="" />
        <label>
            <input type="submit" value="<fmt:message key="vacancy"/>"/>
        </label>
    </form>
</header>
<section class="enterInputs">
    <form class="formReg" method="POST" action="controller">
        <input type="hidden" name="command" value="change_info"/>
        <label>
            <fmt:message key="name"/>
            <input type="text" name="name" value=""/>
        </label>
        <label>
            <fmt:message key="sname"/>
            <input type="text" name="sname" value=""/>
        </label>
        <label>
            <fmt:message key="phone"/>
            <input type="text" name="phone" value=""/>
        </label>
        <label>
            <fmt:message key="email"/>
            <input type="text" name="email" value=""/>
        </label>
        <input type="submit" class="button" value="<fmt:message key="apply"/>"/>
    </form>
</section>

</body>
</html>
