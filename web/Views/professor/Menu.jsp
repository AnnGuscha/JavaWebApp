<%@ page import="manager.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<ul class="nav navbar-nav" role="navigation">
    <li><a href="/professor" class="navbar-brand"><fmt:message bundle="${loc}" key="about_me"/></a></li>
    <li><a href="/professor/students" class="navbar-brand"><fmt:message bundle="${loc}" key="students"/></a></li>
</ul>