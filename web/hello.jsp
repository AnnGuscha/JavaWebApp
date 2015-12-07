<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/6/2015
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
xfgjdghjdghjdghjgfhjdg
<h1>
    <%
        String name = request.getParameter("color");
        if (name == null || name.length() == 0) {
    %>
    Hello, world !
    <% } else {
    %>
    Hello, world ! I'm <%= name%>
    <%
        }
    %>
</h1>
</body>
</html>
