<%@ taglib prefix="myTag" uri="/WEB-INF/menuTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.User" %>
<%@ page import="manager.Locale" %>
<%@ page import="manager.Role" %>
<html>
<jsp:include page="Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc" />
<body>
<% User user = (User) request.getAttribute("user");%>
<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2><fmt:message bundle="${loc}" key="profile.my_profile"/></h2>
    <br/>
    <div class="form-group col-xs-3">
        <h4>
            <label class="control-label col-xs-12">
                <fmt:message bundle="${loc}" key="login"/>: <%= user.getLogin() %>
            </label>
        </h4>
        <br/>
        <h4>
            <label class="control-label col-xs-12">
                <fmt:message bundle="${loc}" key="profile.you_is"/> <%= Role.getRole(user.getRole()).toString() %>
            </label>
        </h4>
        <br/>
        <h4>
            <label class="control-label col-xs-12">
                <fmt:message bundle="${loc}" key="profile.language_is"/> <%= Locale.valueOf(user.getLocale().toUpperCase()).getName().toLowerCase() %>
            </label>
        </h4>
        <br/>
    </div>
    <a href="/profile/edit"> <img src="/content/images/pen-20.png"/></a>
</div>
</body>
</html>

