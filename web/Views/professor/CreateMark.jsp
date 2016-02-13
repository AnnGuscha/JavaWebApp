<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.Course" %>
<%@ page import="entity.Student" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../Menu.jsp"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="mark"/></h2>
    <%
        Student student = (Student) request.getAttribute("student");
        Course course = (Course) request.getAttribute("course");
        String studentName = student.getSurName() + " " + student.getName() + " " + student.getPatronymicName();
    %>
    <form action="/api/professor/mark/create" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <label for="idCourse" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="course"/>:</label>
            <input type="hidden" name="idCourse" id="idCourse" value="<%= course.getId()  %>"/>
            <input type="text" class="form-control" value="<%= course.getName()  %>"
                   readonly/>
            <br/>
            <label for="idStudent" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="student"/>:</label>
            <input type="hidden" name="idStudent" id="idStudent" class="form-control" value="<%= student.getId()  %>"/>
            <input type="text" class="form-control" value="<%= studentName  %>"
                   readonly/>
            <br/>
            <br/>
            <label for="comment" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="comment"/>:</label>
            <input type="text" name="comment" id="comment" class="form-control"
                   value=""
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
