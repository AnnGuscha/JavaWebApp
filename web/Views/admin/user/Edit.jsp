<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="entity.User" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../Header.jsp"/>
<body>
<jsp:include page="../../Menu.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="user"/></h2>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <form action="/api/admin/user/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idUser" name="idUser" value="<%= user.getId() %>"/>
            <label for="login" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="login"/>:</label>
            <input type="text" name="login" id="login" class="form-control" value="<%= user.getLogin() %>"
                   required="true"/>
            <br/>
            <label for="password" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="password"/>:</label>
            <input type="password" name="password" id="password" value="<%= user.getPassword() %>" class="form-control"
                   readonly/>
            <br/>
            <label for="role" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="role"/>:</label>
            <input type="text" name="role" id="role" class="form-control"
                   value="<%=user.getRole() %>"
                   required="true"/>
            <br/>
            <label for="locale" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="locale"/>:</label>
            <input type="text" name="locale" id="locale" class="form-control"
                   value="<%=user.getLocale() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
