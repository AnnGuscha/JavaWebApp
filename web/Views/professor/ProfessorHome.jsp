<%@ page import="entity.Professor" %><%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<body>
<jsp:include page="Menu.jsp"/>
<% Professor professor = (Professor) request.getAttribute("professor");%>
<div id="demo">

    <h2>Professor</h2>

    <p>
        <a href="/professor/edit"> <img
                src="/content/images/pen-20.png"/></a><%= professor.getSurName() %> <%= professor.getFirstName() %> <%= professor.getPatronymicName() %>
    </p>

</div>
</body>
</html>