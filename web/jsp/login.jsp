<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <section class="enterInputs">
        <input type="hidden" name="command" value="login" />
        <label>
            <fmt:message key="login"/>:<br/>
            <input type="text" id="Login" class="formInput" name="login" value=""/><br/>
            <span class="trueLogin"><fmt:message key="yes"/></span>
            <span class="falseLogin"><fmt:message key="no"/></span>
        </label>
        <label>
            <fmt:message key="password"/>:<br/>
            <input type="password" id="Password" class="formInput" name="password" value=""/><br/>
            <span class="truePassword"><fmt:message key="yes"/></span>
            <span class="falsePassword"><fmt:message key="no"/></span>
        </label>
        <span class="errorMes">${errorLoginPassMessage}</span>
        <span class="errorMes">${wrongAction}</span>
            <span class="errorMes">${nullPage}</span>
        <input type="submit"  class="button" value="<fmt:message key="LogIn"/>"/>

    </section>
</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_registration" />
    <input type="submit"  class="button reg"value="<fmt:message key="registration"/>"/>
</form>
<hr/>


<script type="text/javascript"><%@include file="../js/Script.js" %></script>
</body>
</html>