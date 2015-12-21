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
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    if (userName == null) response.sendRedirect("/login");
%>
<html>
<jsp:include page="Header.jsp"/>
<body style="background-image: url(/Content/Images/img.jpg); background-position: center;background-repeat: no-repeat;">
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
