<%@ page import="Entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/10/2015
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="../Menu.jsp"/>

<div id="container">
    <h2>Students</h2>
    <%Student student = (Student) request.getAttribute("student");%>
    <form action="/api/student/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value="<%= student.getName() %>"
                   required="true"/>

            <label for="surName" class="control-label col-xs-4">Last name:</label>
            <input type="text" name="lastName" id="surName" class="form-control" value="<%= student.getSurName() %>"
                   required="true"/>

            <label for="patronymicName" class="control-label col-xs-4">Patronymic name:</label>
            <input type="text" name="lastName" id="patronymicName" class="form-control"
                   value="<%= student.getPatronymicName() %>"
                   required="true"/>

            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
        <%--First Name*--%>
        <%--<input type="text" name="firstName" value="<%= student.getName() %>" size=15 maxlength=20></td>--%>

        <%--Last Name*--%>
        <%--<input type="text" name="lastName" value="<%= student.getSurName() %>" size=15 maxlength=20></td>--%>

        <%--<input type="submit" value="Submit"> <input type="reset" value="Reset">--%>
    </form>
</div>
</body>
</html>
