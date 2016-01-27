<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String userName = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    } else userName = (String) session.getAttribute("user");
%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li><a href="/professor_home" class="navbar-brand">About me</a></li>
                <li><a href="/professor_students" class="navbar-brand">My students</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="" class="navbar-brand">Hi <%=userName %>
                </a></li>
                <li><a href="/logout">Log Out</a></li>
            </ul>
        </div>
    </div>
</div>
