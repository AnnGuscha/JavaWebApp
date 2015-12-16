<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/11/2015
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="HomeController" class="navbar-brand">Home</a>
            <%--@Html.ActionLink("Компьютерная фирма", "Index", "Home", null, new { @class = "navbar-brand" })--%>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li><a href="StudentHome.jsp" class="navbar-brand">About me</a></li>
                <li><a href="StudentCourses.jsp" class="navbar-brand">My aducation</a></li>
                <li><a href="AllCourses.jsp" class="navbar-brand">All courses</a></li>
            </ul>
            <%--@Html.Partial("_LoginPartial")--%>
        </div>
    </div>
</div>
