<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/8/2015
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    } else userName = (String) session.getAttribute("user");
%>
<html>
<jsp:include page="Header.jsp"/>
<body style="background-image: url(/content/images/img.jpg); background-position: center;background-repeat: no-repeat;">
<div class="container body-content">
    <jsp:include page="Menu.jsp"/>
    <div id="container">
        <div id="demo">
            <br/>
            <br/>

            <h1>Hello <%=userName %>
            </h1>
        </div>
    </div>
</div>
</body>
</html>
