<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
        <fmt:message key="myProfile"/>
    </title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <form method="POST" action="controller">
        <div class="logo">
            <h3>HR-system</h3>
        </div>
        <input type="hidden" name="command" value="result"/>
        <label>
            <input type="submit" value="<fmt:message key="result"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_my_profile"/>
        <label>
            <input type="submit" value="<fmt:message key="myProfile"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies"/>
        <input type="hidden" name="page" value="1"/>
        <input type="hidden" name="direction" value=""/>
        <label>
            <input type="submit" value="<fmt:message key="vacancy"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="logout"/>
        <label>
            <input type="submit" value="<fmt:message key="LogOut"/>"/>
        </label>
    </form>
</header>
<h3 class="Registr"><fmt:message key="myProfile"/></h3>
<hr/>
<main>
    <table border="1">
        <tr>
            <td><fmt:message key="login"/></td>
            <td><fmt:message key="name"/></td>
            <td><fmt:message key="sname"/></td>
        </tr>
        <tr>
            <td>${requestScope.user.login}</td>
            <td>${requestScope.user.name}</td>
            <td>${requestScope.user.sname}</td>
        </tr>
    </table>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_change_info"/>
        <input type="submit" class="button btnProfile" value="<fmt:message key="changeInfo"/>"/>
    </form>
    <h3><fmt:message key="myProposal"/></h3>
    <table border="1">
        <tr>
            <td><fmt:message key="vacancyName"/></td>
            <td><fmt:message key="companyName"/></td>
        </tr>
        <tr>
            <c:forEach items="${requestScope.proposalList}" var="prop">

            <td>${prop.vacancy}</td>
            <td>${prop.company}</td>
            <td>
                <form method="POST" action="controller">
                    <input type="hidden" name="command" value="cancel_proposal"/>
                    <input type="hidden" name="id" value="${prop.id}"/>
                    <input type="submit" class="button btnProfile" value="<fmt:message key="cancel"/>"/>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
    ${requestScope.errorAddProposal}
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="get_vacancies"/>
        <input type="hidden" name="page" value="1"/>
        <input type="hidden" name="direction" value=""/>
        <input type="submit" class="button btnProfile" value="<fmt:message key="addProposal"/>"/>
    </form>
    <h3><fmt:message key="futurePreview"/></h3>
    <hr/>
    <table border="1">
        <tr>
            <td><fmt:message key="vacancyName"/></td>
            <td><fmt:message key="companyName"/></td>
            <td><fmt:message key="date"/></td>
            <td><fmt:message key="time"/></td>
            <td><fmt:message key="place"/></td>
        </tr>
        <tr>
            <c:forEach items="${requestScope.previewList}" var="prev">

            <td>${prev.vacancy}</td>
            <td>${prev.company}</td>
            <td>${prev.dateStr}</td>
            <td>${prev.timeStr}</td>
            <td>${prev.place}</td>
        </tr>
        </c:forEach>
    </table>
    <h3><fmt:message key="futureTechInterview"/></h3>
    <table border="1">
        <tr>

            <td><fmt:message key="vacancyName"/></td>
            <td><fmt:message key="companyName"/></td>
            <td><fmt:message key="date"/></td>
            <td><fmt:message key="time"/></td>
            <td><fmt:message key="place"/></td>
        </tr>
        <tr>
            <c:forEach items="${requestScope.techList}" var="tech">

            <td>${tech.vacancy}</td>
            <td>${tech.company}</td>
            <td>${tech.date}</td>
            <td>${tech.time}</td>
            <td>${tech.place}</td>
        </tr>
        </c:forEach>
    </table>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="delete_user"/>
        <input type="submit" class="button btnProfile" value="<fmt:message key="deleteProfile"/>"/>
    </form>
</main>
<hr/>
<footer>
    <h4><ex:Info/></h4>
</footer>
</body>
</html>