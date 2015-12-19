<%@ page import="Models.forProfessor.CourseModel" %><%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/19/2015
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>
<%
    CourseModel course = (CourseModel) request.getAttribute("courseModel");
%>
<script type="text/javascript">
    var course =<%= course.getId()%>;

    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "api/professor_students",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "visible": false,
                    "targets": 0
                },
                {
                    "render": function (data, type, row) {
                        if (data == null)
                            return ' <a href=\"professor_home/create_mark?id=' + row.id + '&course=' + course + '\"><img src="/Content/Images/add-20.png"/></a> ';
                        else
                            return data + ' <a href=\"professor_home/edit_mark?id=' + row.id + '&course=' + course + '\"><img src="/Content/Images/pen-20.png"/></a>' +
                                    '<a href=\"professor_home/delete_mark?id=' + row.id + '&course=' + course + '\"><img src="/Content/Images/delete-20.png"/></a>';
                    },
                    "width": "30%",
                    "targets": 2
                }
            ],
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "mark"}
            ]
        });


        $('#myDataTable tbody').on('click', 'tr', function () {

            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
            var href = $('a:contains(" ")', this).attr('data');
            window.location.href = "Details/" + href;

        });
    });
</script>
<body>
<jsp:include page="Menu.jsp"/>

<div id="container">

    <br/>
    <br/>

    <h2><%= course.getName()%>
    </h2>
    <h5><%= course.getDescription()%>
    </h5>
    <br/>
    <h4>Students</h4>

    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Student name</th>
            <th>Mark</th>
        </tr>
        </thead>
    </table>
</div>
</div>
</body>
</html>
