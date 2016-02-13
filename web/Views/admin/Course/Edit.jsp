<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.Course" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<%
    Course course = (Course) request.getAttribute("course");
%>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="course"/></h2>

    <form action="/api/admin/course/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" name="_method" value="post"/>
            <input type="hidden" id="idCourse" name="idCourse" value="<%= course.getId() %>"/>
            <label for="name" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="name"/>:</label>
            <input type="text" name="name" id="name" class="form-control" value="<%= course.getName() %>"
                   required="true"/>
            <br/>
            <br/>
            <label for="idProfessor" class="control-label col-xs-4"><fmt:message bundle="${loc}"
                                                                                 key="professor"/>:</label>
            <input type="text" name="idProfessor" id="idProfessor" class="form-control"
                   value="<%= course.getIdProfessor() %>"
                   required="true"/>
            <br/>
            <label for="description" class="control-label col-xs-6"><fmt:message bundle="${loc}"
                                                                                 key="description"/>:</label>
            <input type="text" name="description" id="description" class="form-control"
                   value="<%=course.getDescription() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
