<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/11/2015
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    if (userName == null) response.sendRedirect("/login");
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
            <a class="navbar-brand" href="/index">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li><a href="/student" class="navbar-brand">Students</a></li>
                <li><a href="/professor" class="navbar-brand">Professors</a></li>
                <li><a href="/course" class="navbar-brand">Courses</a></li>
                <li><a href="/mark" class="navbar-brand">Marks</a></li>
                <li><a href="/liststudents" class="navbar-brand">ListStudents</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="" class="navbar-brand">Hi <%=userName %>
                </a></li>
                <li><a href="/logout">Log Out</a></li>
            </ul>
        </div>
    </div>
</div>
