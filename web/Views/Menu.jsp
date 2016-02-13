<%@ page import="manager.Locale" %>
<%@ page import="manager.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="myTag" uri="/WEB-INF/customTag.tdl" %>
<%
    String userName = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    } else userName = (String) session.getAttribute("user");
    Role role = (Role) session.getValue("role");
    Locale locale = (Locale) session.getValue("locale");
%>
<fmt:setLocale value="<%=locale.getLanguage()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<%String path = role.name().toLowerCase() + "/Menu.jsp";%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/<%=role.name().toLowerCase()%>">
                <fmt:message bundle="${loc}" key="home"/>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <jsp:include flush="true" page="<%=path%>"/>
            <%--<myTag:menu role="1"/>--%>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/profile" class="navbar-brand">
                        <fmt:message bundle="${loc}" key="hi"/> <%=userName %>
                    </a>
                </li>
                <li>
                    <a href="/logout">
                        <fmt:message bundle="${loc}" key="logout"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
