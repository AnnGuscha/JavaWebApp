<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/13/2015
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>

<body>

<jsp:include page="../Menu.jsp"/>

<div class="container">
    <h2>Course</h2>

    <form action="/api/course" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">
            <input type="hidden" name="_method" value="put"/>
            <input type="hidden" id="idCourse" name="idCourse" value=""/>


            <label for="name" class="control-label col-xs-4">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value=""
                   required="true"/>

            <br/>
            <label for="idProfessor" class="control-label col-xs-4">Professor:</label>
            <input type="text" name="idProfessor" id="idProfessor" class="form-control" value=""
                   required="true"/>
            <br/>
            <label for="description" class="control-label col-xs-6">Description:</label>
            <input type="text" name="description" id="description" class="form-control"
                   value=""
                   required="true"/>

            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>
