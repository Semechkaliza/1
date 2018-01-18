<%@ page language ="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        Welcome
    </title>
</head>
<body>
<h3>Welcome</h3>
<hr/>
<table border="1">
    <tr>
        <td>login</td>
        <td>name</td>
        <td>sname</td>
        <td>role</td>
        <td>rating</td>
    </tr><tr>
    <c:forEach items="${requestScope.user}" var="users">

        <td>${users.login}</td>
        <td>${users.name}</td>
        <td>${users.sname}</td>
        <td>${users.role}</td>
        <td>${users.rating}</td>
</tr>

    </c:forEach>
</table>

<form method="POST" action="controller">
    <input type="hidden" name="command" value="getvacancies" />
    <input type="submit" value="vacancy"/>
</form>
<a href="controller?command=logout">Logout</a>
</body>
</html>