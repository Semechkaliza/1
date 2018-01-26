<%--
  Created by IntelliJ IDEA.
  User: lgris
  Date: 26.01.2018
  Time: 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.changeInfo}</title>
</head>
<body>${requestScope.name}
<form method="POST" action="controller">
<input type="hidden" name="command" value="change_info"/>
<input type="text" name="name" value=""/><br/>
${requestScope.sname}
<input type="text" name="sname" value=""/><br/>
${requestScope.phone}
<input type="text" name="phone" value=""/><br/>
${requestScope.email}
<input type="text" name="email" value=""/><br/>
<input type="submit" value="${requestScope.apply}"/>
</form>
</body>
</html>
