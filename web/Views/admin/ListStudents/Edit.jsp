<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.ListStudents" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<div class="container">
    <h2>List students</h2>
    <%
        ListStudents listStudents = (ListStudents) request.getAttribute("listStudents");
    %>
    <form action="/api/admin/liststudents/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idListStudents" name="idListStudents" value="<%= listStudents.getId() %>"/>
            <br/>
            <label for="idCourse" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="course"/>:</label>
            <input type="text" name="idCourse" id="idCourse" class="form-control"
                   value="<%=listStudents.getIdCourse() %>"
                   required="true"/>
            <br/>
            <label for="idStudent" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="student"/>:</label>
            <input type="text" name="idStudent" id="idStudent" class="form-control"
                   value="<%= listStudents.getIdStudent()  %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
