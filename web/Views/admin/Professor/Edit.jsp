<%@ page import="entity.Professor" %>
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

<div class="container">
    <h2>Professor</h2>

    <%
        Professor professor = (Professor) request.getAttribute("professor");
    %>

    <form action="/api/admin/professor/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idProfessor" name="idProfessor" value="<%= professor.getId() %>"/>

            <br/>
            <label for="firstName" class="control-label col-xs-6">Name:</label>
            <input type="text" name="firstName" id="firstName" class="form-control"
                   value="<%= professor.getFirstName() %>" required="true"/>
            <br/>

            <label for="surName" class="control-label col-xs-4">Surname:</label>
            <input type="text" name="surName" id="surName" class="form-control" value="<%= professor.getSurName() %>"
                   required="true"/>
            <br/>
            <label for="patronymicName" class="control-label col-xs-4">PatronymicName:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control"
                   value="<%= professor.getPatronymicName() %>"
                   required="true"/>
            <br/>
            <label for="userId" class="control-label col-xs-4">User id:</label>
            <input type="text" name="userId" id="userId" class="form-control"
                   value="<%= professor.getUserId() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
