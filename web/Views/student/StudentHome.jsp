<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.Student" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<body>
<%String locale = session.getValue("locale").toString();%>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).getLanguage()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<jsp:include page="../Menu.jsp"/>
<% Student student = (Student) request.getAttribute("student");%>
<div id="demo">
    <h2><fmt:message bundle="${loc}" key="student"/></h2>
    <p>
        <%= student.getSurName() %> <%= student.getName() %> <%= student.getPatronymicName() %>
    </p>
    <a href="/student/edit"> <img src="/content/images/pen-20.png"/></a>
</div>
</body>
</html>
