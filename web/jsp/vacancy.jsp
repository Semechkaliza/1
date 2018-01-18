<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        Vacancy
    </title>
</head>
<body>
<h3>Vacancy</h3>
<hr/>
<table border="1">
    <tr>
        <td>company</td>
        <td>vacancy</td>
        <td>salary</td>
        <td>skill</td>
        <td>other</td>
    </tr><tr>
    <c:forEach items="${requestScope.vacancy}" var="vacancy">

        <td>${vacancy.company}</td>
        <td>${vacancy.vacancy}</td>
        <td>${vacancy.salary}</td>
        <td>${vacancy.skill}</td>
        <td>${vacancy.other}</td>
</tr>

    </c:forEach>
</table>

<a href="controller?command=logout">Logout</a>
</body>
</html>