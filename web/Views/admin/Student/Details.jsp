<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<%@ page import="manager.Locale" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<div class="container">
    <% Student student = (Student) request.getAttribute("student");%>
    <h2><fmt:message bundle="${loc}" key="student"/></h2>
    <h4>
        <%= student.getSurName() %>
    </h4>
    <h4>
        <%= student.getName() %>
    </h4>
    <h4>
        <%= student.getPatronymicName() %>
    </h4>
    <a href="/admin/student/edit/<%= student.getId() %>"> <img src="/content/images/pen-20.png"/></a>
</div>
</body>
</html>

