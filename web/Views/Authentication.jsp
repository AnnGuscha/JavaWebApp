<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="Header.jsp"/>

<body>
<div class="container">
    <h2 class="form-signin-heading">Authentication</h2>

    <form action="/login" method=post role="form" data-toggle="validator" class="form-signin">
        <div class="form-group col-xs-4">

            <input type="text" name="login" id="login" class="form-control" placeholder="Login"
                   required autofocus/>
            <input type="password" name="password" id="password" class="form-control" placeholder="Password"
                   required/>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
            <button type="submit" class="btn btn-lg btn-primary  btn-md btn-block">Sign In</button>
            <a href="/registr" type="button" class="btn btn-lg btn-primary  btn-md btn-block">Registration</a>
        </div>
    </form>

</div>
</body>
</html>