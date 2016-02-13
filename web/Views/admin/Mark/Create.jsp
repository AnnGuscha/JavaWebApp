<%@ page import="entity.Course" %>
<%@ page import="manager.Locale" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc" />
<body>
<jsp:include page="../../Menu.jsp"/>
<script>
    $(document).ready(function () {
        $("#courses").val("${request.getAttribute("listCourses")}").attr('selected', 'selected');
    });
</script>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="mark"/></h2>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("listCourses");
    %>
    <form action="/api/admin/mark/create" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idMark" name="idMark" value=""/>
            <label class="control-label col-xs-4"><fmt:message bundle="${loc}" key="course"/>:</label>
            <select id="idCourse" name="idCourse" class="form-control">
                <c:forEach var="course" items="<%= courses  %>">
                    <option value="${course.getId()}" class="form-control">${course.getName()}</option>
                </c:forEach>
            </select>
            <br/>
            <label for="idStudent" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="student"/>:</label>
            <input type="text" name="idStudent" id="idStudent" class="form-control" value=""
                   required="true"/>
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
