<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../Header.jsp"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="list_students"/></h2>
    <form action="/api/admin/liststudents/create" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="id" name="id" value=""/>
            <br/>
            <label for="idCourse" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="course"/>:</label>
            <input type="text" name="idCourse" id="idCourse" class="form-control"
                   value=""
                   required="true"/>
            <br/>
            <label for="idStudent" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="student"/>:</label>
            <input type="text" name="idStudent" id="idStudent" class="form-control" value=""
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
