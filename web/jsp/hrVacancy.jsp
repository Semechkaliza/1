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
        <fmt:message key="vacancy"/>
    </title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header>
    <div class="logo">
        <h3>HR-system</h3>
    </div>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_add_vacancy"/>
        <label>
            <input type="submit" value="<fmt:message key="addVacancy"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_approved"/>
        <label>
            <input type="submit" value="<fmt:message key="approved"/>"/>
        </label>
    </form>
    <form method="POST" action="controller">
        <input type="hidden" name="command" value="go_hr_profile"/>
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

<h3 class="Registr"><fmt:message key="vacancy"/></h3>
<hr/>
<main>
    <table border="1">
        <tr>
            <td><fmt:message key="companyName"/></td>
            <td><fmt:message key="vacancyName"/></td>
            <td><fmt:message key="salary"/></td>
            <td><fmt:message key="other"/></td>
        </tr>
        <tr>
            <c:forEach items="${requestScope.vacanciesList}" var="vacancy">

            <td>${vacancy.company}</td>
            <td>${vacancy.vacancy}</td>
            <td>${vacancy.salary}</td>
            <td>${vacancy.other}</td>
            <td>
                <form method="POST" action="controller">
                    <input type="hidden" name="command" value="close_vacancy"/>
                    <input type="hidden" name="id" value="${vacancy.vacancyId}"/>
                    <input type="submit" class="button btnProfile" value="<fmt:message key="closeVacancy"/>"/>
                </form>
            </td>
        </tr>

        </c:forEach>
        ${emptyVacanciesList}
    </table>
    <section class="btnLeftRight">
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="get_vacancies"/>
            <input type="hidden" name="page" value="${requestScope.page}"/>
            <input type="hidden" name="direction" value="prev"/>
            <input type="submit" class="button" value="<<"/>
        </form>
        <form method="POST" action="controller">
            <input type="hidden" name="command" value="get_vacancies"/>
            <input type="hidden" name="page" value="${requestScope.page}"/>
            <input type="hidden" name="direction" value="next"/>
            <input type="submit" class="button" value=">>"/>
        </form>
    </section>
</main>
<footer>
    <h4><ex:Info/></h4>
</footer>
</body>
</html>