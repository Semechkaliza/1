<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <title>
        <fmt:message key="login"/>
    </title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>

<form method="POST" action="controller">
    <header>
        <div class="logoLoc">
            <h3>HR-system</h3>
        </div>
        <input type="hidden" value="locale"/>
        <label class="lng">
            <input name="locale" type="radio" value="ru" checked>
            RU</label>
        <label class="lng">
            <input name="locale" type="radio" value="en">
            EN</label>
        <label class="lng">
            <input name="locale" type="radio" value="be">
            BE</label>
        <br>
    </header>
    <hr/>
    <section class="enterInputs">
        <input type="hidden" name="command" value="login"/>
        <label>
            <fmt:message key="login"/>:<br/>
            <input type="text" id="Login" class="formInput" name="login" value=""/><br/>
        </label>
        <label>
            <fmt:message key="password"/>:<br/>
            <input type="password" id="Password" class="formInput" name="password" value=""/><br/>
        </label>
        <span class="errorMes">${errorLoginPassMessage}</span>
        <span class="errorMes">${wrongAction}</span>
        <span class="errorMes">${nullPage}</span>
        <input type="submit" class="button" value="<fmt:message key="LogIn"/>"/>

    </section>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_registration"/>
    <input type="submit" class="button reg" value="<fmt:message key="registration"/>"/>
</form>
<script type="text/javascript">
    <%@include file="../js/Script.js" %>
</script>
<footer>
    <h4><ex:Info/></h4>
</footer>
</body>
</html>