<%@ page import="Entity.Course" %>
<%@ page import="Entity.Mark" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/13/2015
  Time: 3:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="../Menu.jsp"/>
<script>
    $(document).ready(function () {
        $("#courses").val("${request.getAttribute("listCourses")}").attr('selected', 'selected');
//        requestScope.listCourses
    });

</script>
<div class="container">
    <h2>Mark</h2>

    <%
        Mark mark = (Mark) request.getAttribute("mark");
        List<Course> courses = (List<Course>) request.getAttribute("listCourses");
    %>

    <form action="/api/mark/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idMark" name="idMark" value="<%= mark.getId() %>"/>


            <label class="control-label col-xs-4">Course:</label>
            <select id="idCourse" name="idCourse" class="form-control">
                <c:forEach var="course" items="<%= courses  %>"><%--<c:forEach var="course" items="${courses}">--%>
                    <option value="${course.getId()}" class="form-control">${course.getName()}</option>
                </c:forEach>
            </select>

            <br/>
            <label for="idStudent" class="control-label col-xs-4">Student:</label>
            <input type="text" name="idStudent" id="idStudent" class="form-control" value="<%= mark.getIdStudent()  %>"
                   required="true"/>
            <br/>
            <label for="comment" class="control-label col-xs-6">Comment:</label>
            <input type="text" name="comment" id="comment" class="form-control"
                   value="<%=mark.getComment() %>"
                   required="true"/>

            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
