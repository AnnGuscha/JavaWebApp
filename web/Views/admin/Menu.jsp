<%@ page import="manager.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8" />
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc" />
<ul class="nav navbar-nav" role="navigation">
    <li><a href="/admin/student" class="navbar-brand"><fmt:message bundle="${loc}" key="students" /></a></li>
    <li><a href="/admin/professor" class="navbar-brand"><fmt:message bundle="${loc}" key="professors" /></a></li>
    <li><a href="/admin/course" class="navbar-brand"><fmt:message bundle="${loc}" key="courses" /></a></li>
    <li><a href="/admin/mark" class="navbar-brand"><fmt:message bundle="${loc}" key="marks" /></a></li>
    <li><a href="/admin/liststudents" class="navbar-brand"><fmt:message bundle="${loc}" key="list_students" /></a></li>
    <li><a href="/admin/user" class="navbar-brand"><fmt:message bundle="${loc}" key="users" /></a></li>
</ul>
