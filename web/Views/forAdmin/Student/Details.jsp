<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/23/2015
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.Student" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="../Menu.jsp"/>

<div class="container">
    <% Student student = (Student) request.getAttribute("student");%>


    <h2>Student</h2>

    <h4>
        <%= student.getSurName() %>
    </h4>
    <h4>
        <%= student.getName() %>
    </h4>
    <h4>
        <%= student.getPatronymicName() %>
    </h4>

    <a href="/student/edit/<%= student.getId() %>"> <img src="/Content/Images/pen-20.png"/></a>

</div>
</body>
</html>

