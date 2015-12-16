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
                <li><a href="/student" class="navbar-brand">Students</a></li>
                <li><a href="/professor" class="navbar-brand">Professors</a></li>
                <li><a href="/course" class="navbar-brand">Courses</a></li>
                <li><a href="/mark" class="navbar-brand">Marks</a></li>
                <li><a href="/liststudents" class="navbar-brand">ListStudents</a></li>
            </ul>
            <%--@Html.Partial("_LoginPartial")--%>
        </div>
    </div>
</div>
