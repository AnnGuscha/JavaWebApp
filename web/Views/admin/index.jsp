<%@ page import="manager.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="myTag" uri="/WEB-INF/customTag.tdl" %>
<%
    String userName = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    } else userName = (String) session.getAttribute("user");
    Locale locale = (Locale) session.getValue("locale");
%>
<fmt:setLocale value="<%=locale.getLanguage()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<html>
<jsp:include page="Header.jsp"/>
<body style="background-image: url(/content/images/img.jpg); background-position: center;background-repeat: no-repeat;">
<div class="container body-content">
    <jsp:include page="../Menu.jsp"/>
    <div id="container">
        <div id="demo">
            <br/>
            <br/>

            <h1><fmt:message bundle="${loc}" key="hi"/> <%=userName %>
            </h1>
            <%--<myTag:menu role="1"/>--%>
        </div>
    </div>
</div>
</body>
</html>
