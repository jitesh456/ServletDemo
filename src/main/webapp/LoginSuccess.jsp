<%--
  Created by IntelliJ IDEA.
  User: jitesh
  Date: 08/04/20
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginSuccess</title>
</head>
<body>
<h1>Hi "<%=request.getAttribute("username")%>" Login Successful</h1>
<a href="login.html">Login Page</a>
</body>
</html>
