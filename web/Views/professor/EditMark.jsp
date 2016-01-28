<%@ page import="models.professor.MarkModel" %><%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 9:09 PM
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
        MarkModel mark = (MarkModel) request.getAttribute("mark");
    %>

    <form action="/api/professor/mark/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idMark" name="idMark" value="<%= mark.getId() %>"/>


            <label for="idCourse" class="control-label col-xs-4">Course:</label>
            <input type="hidden" name="idCourse" id="idCourse" value="<%= mark.getIdCourse()  %>"/>
            <input type="text" class="form-control" value="<%= mark.getNameCourse()  %>"
                   readonly/>
            <br/>

            <label for="idStudent" class="control-label col-xs-4">Student:</label>
            <input type="hidden" name="idStudent" id="idStudent" class="form-control"
                   value="<%= mark.getIdStudent()  %>"/>
            <input type="text" class="form-control" value="<%= mark.getNameStudent()  %>"
                   readonly/>
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
