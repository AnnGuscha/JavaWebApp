<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/20/2015
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="Header.jsp"/>

<body>
<div class="container">
    <h2 class="form-signin-heading">Registration</h2>

    <form action="/registr" method=post role="form" data-toggle="validator">
        <div class="form-group col-xs-4">

            <label for="login" class="control-label col-xs-4">Login:</label>
            <input type="text" name="login" id="login" class="form-control" value=""
                   required="true"/>
            <br/>
            <label for="password" class="control-label col-xs-4">Password:</label>
            <input type="text" name="password" id="password" class="form-control" value=""
                   required="true"/>
            <br/>

            <button type="submit" class="btn btn-primary  btn-md">Registration</button>
        </div>
    </form>
</div>
</body>
</html>
