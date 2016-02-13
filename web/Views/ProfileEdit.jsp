<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="entity.User" %>
<%@ page import="manager.Locale" %>
<%@ page import="manager.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/menuTag.tld" prefix="myTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<% User user = (User) request.getAttribute("user"); %>
<%--<myTag:menu role="<%=user.getRole()%>"/>--%>
<
<jsp:include page="Menu.jsp"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="user"/></h2>

    <form action="/api/profile/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="id" name="id" value="<%= user.getId() %>"/>

            <label for="login" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="login"/>:</label>
            <input type="text" name="login" id="login" class="form-control" value="<%= user.getLogin() %>"
                   required="true"/>
            <br/>
            <label for="password" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="password"/>:</label>
            <input type="password" name="password" id="password" value="<%= user.getPassword() %>" class="form-control"
                   required="true"/>
            <br/>
            <label for="role" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="role"/>:</label>
            <input type="hidden" name="role" id="role"
                   value="<%=user.getRole()%>"
                   readonly/>
            <input type="text" name="" id="" class="form-control"
                   value="<%=Role.getRole(user.getRole())%>"
                   readonly/>
            <br/>
            <label for="locale" class="control-label col-xs-6"><fmt:message bundle="${loc}" key="locale"/>:</label>
            <%
                pageContext.setAttribute("userLocale", user.getLocale().toLowerCase());
            %>
            <select id="locale" name="locale" class="form-control">
                <c:forEach var="locale" items="<%= Locale.values()  %>">
                    <option value="${locale.toString()}" class="form-control"
                            <c:if test="${fn:toLowerCase(locale).equals(userLocale)}">
                                selected
                            </c:if>>
                            ${locale.getName()}
                    </option>
                </c:forEach>
            </select>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>

