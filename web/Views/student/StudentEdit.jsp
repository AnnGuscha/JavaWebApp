<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/10/2015
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2>Student</h2>
    <%Student student = (Student) request.getAttribute("student");%>
    <form action="/api/student/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idStudent" name="idStudent" value="<%= student.getId() %>"/>

            <label for="name" class="control-label col-xs-4">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value="<%= student.getName() %>"
                   required="true"/>
            <br/>
            <label for="surName" class="control-label col-xs-4">Last name:</label>
            <input type="text" name="surName" id="surName" class="form-control" value="<%= student.getSurName() %>"
                   required="true"/>
            <br/>
            <label for="patronymicName" class="control-label col-xs-6">Patronymic name:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control"
                   value="<%= student.getPatronymicName() %>"
                   required="true"/>

            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
