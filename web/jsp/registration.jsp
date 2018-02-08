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
        <fmt:message key="registration"/>
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
                <input name="locale" type="radio" value="ru">
                RU</label>
            <label class="lng">
                <input name="locale" type="radio" value="en">
                EN</label>
            <label class="lng">
                <input name="locale" type="radio" value="be" checked>
                BE</label>
            <br>
        </header>
        <section class="enterInputs enterReg">
            <label>
                <fmt:message key="registration"/>
                <input type="hidden" name="command" value="registration" />
            </label>
            <label>
                <input type="text" id="Login" name="login" value="" placeholder="<fmt:message key="login"/>"/>
                <span class="trueLogin"><fmt:message key="yes"/></span>
                <span class="falseLogin"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="password" id="Password" name="password" value="" placeholder="<fmt:message key="password"/>"/>
                <span class="truePassword"><fmt:message key="yes"/></span>
                <span class="falsePassword"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="password" id="Password2" placeholder="<fmt:message key="password"/>"/>
                <span class="truePassword2"><fmt:message key="yes"/></span>
                <span class="falsePassword2"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="text" id="Email" name="email" value="" placeholder="<fmt:message key="email"/>"/>
                <span class="trueEmail"><fmt:message key="yes"/></span>
                <span class="falseEmail"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="text" id="Phone" name="phone" value="" placeholder="<fmt:message key="phone"/>"/>
                <span class="truePhone"><fmt:message key="yes"/></span>
                <span class="falsePhone"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="text" id="Name" name="name" value="" placeholder="<fmt:message key="name"/>"/>
                <span class="trueName"><fmt:message key="yes"/></span>
                <span class="falseName"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="text" id="Sname" name="sname" value="" placeholder="<fmt:message key="sname"/>"/>
                <span class="trueSname"><fmt:message key="yes"/></span>
                <span class="falseSname"><fmt:message key="no"/></span>
            </label>
                ${errorLoginPassMessage}
            <input type="submit" class="button btnReg" value="<fmt:message key="registration"/>"/>
        </section>

</form>
<script type="text/javascript"><%@include file="../js/Script.js" %></script>
</body>
</html>