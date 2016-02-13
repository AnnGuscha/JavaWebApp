<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="manager.Locale" %>
<%@ page import="models.professor.MarkModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc" />
<body>
<jsp:include page="../Menu.jsp"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="mark"/></h2>
    <%
        MarkModel mark = (MarkModel) request.getAttribute("mark");
    %>
    <form action="/api/professor/mark/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idMark" name="idMark" value="<%= mark.getId() %>"/>
            <label for="idCourse" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="course"/>:</label>
            <input type="hidden" name="idCourse" id="idCourse" value="<%= mark.getIdCourse()  %>"/>
            <input type="text" class="form-control" value="<%= mark.getNameCourse()  %>"
                   readonly/>
            <br/>
            <label for="idStudent" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="student"/>:</label>
            <input type="hidden" name="idStudent" id="idStudent" class="form-control"
                   value="<%= mark.getIdStudent()  %>"/>
            <input type="text" class="form-control" value="<%= mark.getNameStudent()  %>"
                   readonly/>
            <br/>
            <label for="comment" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="comment"/>:</label>
            <input type="text" name="comment" id="comment" class="form-control"
                   value="<%=mark.getComment() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
