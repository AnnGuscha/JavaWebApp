<%@ page import="Entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/16/2015
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<body>
<jsp:include page="MenuForStudent.jsp"/>
<% Student student = (Student) request.getAttribute("student");%>
<div id="demo">

    <h2>Student</h2>

    <p><%= student.getSurName() %> <%= student.getName() %> <%= student.getPatronymicName() %>
    </p>

</div>
</body>
</html>