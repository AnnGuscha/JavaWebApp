<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<div class="container">
    <form action="/api/admin/student/create" method="post" role="form" data-toggle="validator">
        <c:if test="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}"/>
        <input type="hidden" id="idStudent" name="idStudent" value="${student.setId()}"/>

        <h2><fmt:message bundle="${loc}" key="student"/></h2>
        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="name"/>:</label>
            <input type="text" name="name" id="name" class="form-control" value=""
                   required="true"/>

            <label for="surName" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="surname"/>:</label>
            <input type="text" name="surName" id="surName" class="form-control" value=""
                   required="true"/>

            <label for="patronymicName" class="control-label col-xs-6"><fmt:message bundle="${loc}"
                                                                                    key="patronymic_name"/>:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control" value=""
                   required="true"/>

            <label for="userId" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="user"/>:</label>
            <input type="text" name="userId" id="userId" class="form-control" value=""
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
