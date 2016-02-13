<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.Professor" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../Menu.jsp"/>
<% Professor professor = (Professor) request.getAttribute("professor");%>
<div id="demo">
    <h2><fmt:message bundle="${loc}" key="professor"/></h2>
    <p>
        <a href="/professor/edit"> <img
                src="/content/images/pen-20.png"/></a><%= professor.getSurName() %> <%= professor.getFirstName() %> <%= professor.getPatronymicName() %>
    </p>
</div>
</body>
</html>