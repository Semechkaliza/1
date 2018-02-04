<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        Index
    </title>
</head>
<body>
<form method="POST" action="controller">
    <input type="hidden" name="command" value="go_login" />
    <jsp:forward page="//by/bsu/hr/controller/controller"/>
</form>

</body>
</html>