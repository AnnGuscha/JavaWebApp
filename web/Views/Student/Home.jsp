<%@ page import="Entity.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/9/2015
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
%>
<table class="table table-striped">
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Last name</td>
    </tr>
    </thead>


    <% for (Student student : studentList) {
        out.print("<tr>" +
                " <td>" + student.getId() + "</td>" +
                "<td>" + student.getName() + "</td>" +
                "<td>" + student.getSurName() + "</td>" +
                " </tr>");
    }%>
</table>
</body>
</html>
