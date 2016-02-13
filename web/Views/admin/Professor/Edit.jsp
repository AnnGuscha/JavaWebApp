<%@ page import="entity.Professor" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="professor"/></h2>
    <%
        Professor professor = (Professor) request.getAttribute("professor");
    %>
    <form action="/api/admin/professor/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idProfessor" name="idProfessor" value="<%= professor.getId() %>"/>
            <br/>
            <label for="firstName" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="name"/>:</label>
            <input type="text" name="firstName" id="firstName" class="form-control"
                   value="<%= professor.getFirstName() %>" required="true"/>
            <br/>
            <label for="surName" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="surname"/>:</label>
            <input type="text" name="surName" id="surName" class="form-control" value="<%= professor.getSurName() %>"
                   required="true"/>
            <br/>
            <label for="patronymicName" class="control-label col-xs-4"><fmt:message bundle="${loc}"
                                                                                    key="patronymic_name"/>:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control"
                   value="<%= professor.getPatronymicName() %>"
                   required="true"/>
            <br/>
            <label for="userId" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="user"/>:</label>
            <input type="text" name="userId" id="userId" class="form-control"
                   value="<%= professor.getUserId() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
