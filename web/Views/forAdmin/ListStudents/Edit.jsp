<%@ page import="Entity.ListStudents" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/13/2015
  Time: 3:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="../Menu.jsp"/>

<div class="container">
    <h2>List students</h2>

    <%
        ListStudents listStudents = (ListStudents) request.getAttribute("listStudents");
    %>

    <form action="/api/liststudents/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idListStudents" name="idListStudents" value="<%= listStudents.getId() %>"/>

            <br/>
            <label for="idCourse" class="control-label col-xs-6">Course:</label>
            <input type="text" name="idCourse" id="idCourse" class="form-control"
                   value="<%=listStudents.getIdCourse() %>"
                   required="true"/>
            <br/>

            <label for="idStudent" class="control-label col-xs-4">Student:</label>
            <input type="text" name="idStudent" id="idStudent" class="form-control"
                   value="<%= listStudents.getIdStudent()  %>"
                   required="true"/>
            <br/>

            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
