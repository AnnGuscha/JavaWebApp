<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<%@ page import="manager.Locale" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<div class="container">
    <h2>Student</h2>
    <%Student student = (Student) request.getAttribute("student");%>
    <form action="/api/admin/student/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idStudent" name="idStudent" value="<%= student.getId() %>"/>
            <label for="name" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="name"/>:</label>
            <input type="text" name="name" id="name" class="form-control" value="<%= student.getName() %>"
                   required="true"/>
            <br/>
            <label for="surName" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="surname"/>:</label>
            <input type="text" name="surName" id="surName" class="form-control" value="<%= student.getSurName() %>"
                   required="true"/>
            <br/>
            <label for="patronymicName" class="control-label col-xs-6"><fmt:message bundle="${loc}"
                                                                                    key="patronymic_name"/>:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control"
                   value="<%= student.getPatronymicName() %>"
                   required="true"/>
            <br/>
            <label for="userId" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="user"/>:</label>
            <input type="text" name="userId" id="userId" class="form-control"
                   value="<%= student.getUserId() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
