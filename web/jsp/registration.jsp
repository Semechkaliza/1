<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld"%>
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
            <div class="logoLoc">
                <h3>HR-system</h3>
            </div>
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
    <h3 class="Registr"><fmt:message key="registration"/></h3>
    <hr/>
    <input type="hidden" name="command" value="registration" />
        <section class="enterInputs enterReg">
            <label>
                <input type="text" id="Login" name="login" value="" placeholder="<fmt:message key="login"/>"/>
                <span class="trueLogin"><fmt:message key="yesLogin"/></span>
                <span class="falseLogin"><fmt:message key="noLogin"/></span>
            </label>
            <label>
                <input type="password" id="Password" name="password" value="" placeholder="<fmt:message key="password"/>"/>
                <span class="truePassword"><fmt:message key="yesPassword"/></span>
                <span class="falsePassword"><fmt:message key="noPassword"/></span>
            </label>
            <label>
                <input type="password" id="Password2" placeholder="<fmt:message key="password"/>"/>
                <span class="truePassword2"><fmt:message key="yes"/></span>
                <span class="falsePassword2"><fmt:message key="no"/></span>
            </label>
            <label>
                <input type="text" id="Email" name="email" value="" placeholder="<fmt:message key="email"/>"/>
                <span class="trueEmail"><fmt:message key="yesEmail"/></span>
                <span class="falseEmail"><fmt:message key="noEmail"/></span>
            </label>
            <label>
                <input type="text" id="Phone" name="phone" value="" placeholder="<fmt:message key="phone"/>"/>
                <span class="truePhone"><fmt:message key="yesPhone"/></span>
                <span class="falsePhone"><fmt:message key="noPhone"/></span>
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
            <div>
                <input type="submit" class="button btnReg" value="<fmt:message key="registration"/>"/>
            </div>

        </section>

</form>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_login" />
    <label>
        <input type="submit" class="backTo" value="<fmt:message key="returnToLogin"/>"/>
    </label>
</form>
<script type="text/javascript"><%@include file="../js/Script.js" %></script>
<footer>
    <h4><ex:Info/></h4>
</footer>
</body>
</html>