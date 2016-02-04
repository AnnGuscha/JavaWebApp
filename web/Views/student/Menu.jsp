<%@ page import="manager.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<ul class="nav navbar-nav" role="navigation">
    <li><a href="/student" class="navbar-brand"><fmt:message bundle="${loc}" key="about_me"/></a></li>
    <li><a href="/student/courses" class="navbar-brand"><fmt:message bundle="${loc}" key="my_education"/></a></li>
    <li><a href="/student/allcourses" class="navbar-brand"><fmt:message bundle="${loc}" key="all_courses"/></a></li>
</ul>
