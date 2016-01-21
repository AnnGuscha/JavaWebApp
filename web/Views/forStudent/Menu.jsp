<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/11/2015
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String userName = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login");
    } else userName = (String) session.getAttribute("user");
%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="HomeController" class="navbar-brand">Home</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li><a href="/student_home" class="navbar-brand">About me</a></li>
                <li><a href="/student_courses" class="navbar-brand">My aducation</a></li>
                <li><a href="/student_allcourses" class="navbar-brand">All courses</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="" class="navbar-brand">Hi <%=userName %>
                </a></li>
                <li><a href="/logout">Log Out</a></li>
            </ul>
        </div>
    </div>
</div>
