<%@ page import="Entity.Course" %>
<%@ page import="Entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2>Mark</h2>

    <%
        Student student = (Student) request.getAttribute("student");
        Course course = (Course) request.getAttribute("course");
        String studentName = student.getSurName() + " " + student.getName() + " " + student.getPatronymicName();
    %>

    <form action="/api/professor_home/create_mark" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">

            <label for="idCourse" class="control-label col-xs-4">Course:</label>
            <input type="hidden" name="idCourse" id="idCourse" value="<%= course.getId()  %>"/>
            <input type="text" class="form-control" value="<%= course.getName()  %>"
                   readonly/>
            <br/>

            <label for="idStudent" class="control-label col-xs-4">Student:</label>
            <input type="hidden" name="idStudent" id="idStudent" class="form-control" value="<%= student.getId()  %>"/>
            <input type="text" class="form-control" value="<%= studentName  %>"
                   readonly/>
            <br/>
            <br/>

            <label for="comment" class="control-label col-xs-6">Comment:</label>
            <input type="text" name="comment" id="comment" class="form-control"
                   value=""
                   required="true"/>
            <br/>

            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
