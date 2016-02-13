<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Professor" %>
<html>
<jsp:include page="../Header.jsp"/>
<body>
<jsp:include page="../Menu.jsp"/>
<div class="container">
    <h2><fmt:message bundle="${loc}" key="professor"/></h2>
    <%Professor professor = (Professor) request.getAttribute("professor");%>
    <form action="/api/professor/edit" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" id="idProfessor" name="idProfessor" value="<%= professor.getId() %>"/>
            <label for="name" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="name"/>:</label>
            <input type="text" name="name" id="name" class="form-control" value="<%= professor.getFirstName() %>"
                   required="true"/>
            <br/>
            <label for="surName" class="control-label col-xs-4"><fmt:message bundle="${loc}" key="surname"/>:</label>
            <input type="text" name="surName" id="surName" class="form-control" value="<%= professor.getSurName() %>"
                   required="true"/>
            <br/>
            <label for="patronymicName" class="control-label col-xs-6"><fmt:message bundle="${loc}"
                                                                                    key="patronymic_name"/>:</label>
            <input type="text" name="patronymicName" id="patronymicName" class="form-control"
                   value="<%= professor.getPatronymicName() %>"
                   required="true"/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md"><fmt:message bundle="${loc}" key="accept"/></button>
        </div>
    </form>
</div>
</body>
</html>
