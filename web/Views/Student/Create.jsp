<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/12/2015
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="../Header.jsp"/>
<body>
<jsp:include page="../Menu.jsp"/>
<div class="container">
    <form action="/api/student/create" method="post" role="form" data-toggle="validator">

        <c:if test="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>

        <input type="hidden" id="action" name="action" value="${action}"/>
        <input type="hidden" id="idStudent" name="idStudent" value="${student.setId()}"/>

        <h2>Student</h2>

        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value=""
                   required="true"/>

            <label for="surName" class="control-label col-xs-4">Last name:</label>
            <input type="text" name="surName" id="surName" class="form-control" value=""
                   required="true"/>

            <label for="patronymicName" class="control-label col-xs-6">Patronymic name:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control" value=""
                   required="true"/>

            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
