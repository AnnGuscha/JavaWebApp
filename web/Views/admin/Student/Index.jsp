<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/9/2015
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Students</h2>
    <!--Search Form -->
    <form action="/student" method="get" id="seachStudentForm" role="form">
        <input type="hidden" id="searchAction" name="searchAction" value="searchByName"/>

        <div class="form-group col-xs-5">
            <input type="text" name="studentName" id="studentName" class="form-control" required="true"
                   placeholder="Type the Name or Last Name of the student"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
        <br/>
        <br/>
    </form>
    <!--Employees List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <form action="/student" method="post" id="studentForm" role="form">
        <input type="hidden" id="idStudent" name="idStudent">
        <input type="hidden" id="action" name="action">
        <c:choose>
            <c:when test="${not empty studentList}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>Name</td>
                        <td>Last name</td>
                    </tr>
                    </thead>
                    <c:forEach var="student" items="${studentList}">
                        <c:set var="classSucess" value=""/>
                        <c:if test="${idStudent == student.getId()}">
                            <c:set var="classSucess" value="info"/>
                        </c:if>
                        <tr class="${classSucess}">
                            <td>
                                <a href="/student?idStudent=${student.getId()}&searchAction=searchById">${student.getId()}</a>
                            </td>
                            <td>${student.getId()}</td>
                            <td>${student.getName()}</td>
                            <td>${student.getSurName()}</td>
                            <td><a href="#" id="remove"
                                   onclick="document.getElementById('action').value = 'remove';document.getElementById('idStudente').value = '${student.getId()}';

                                           document.getElementById('studentForm').submit();">
                                <span class="glyphicon glyphicon-trash"/>
                            </a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br> </br>
                <div class="alert alert-info">
                    No people found matching your search criteria
                </div>
            </c:otherwise>
        </c:choose>
    </form>
    <form action="jsp/new-student.jsp">
        <br/>
        <button type="submit" class="btn btn-primary  btn-md">New student</button>
    </form>
</div>
</body>
</html>
