<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="manager.Locale" %>
<%@ page import="models.professor.CourseModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc" />
<jsp:include page="../Header.jsp"/>
<%
    CourseModel course = (CourseModel) request.getAttribute("courseModel");
%>
<script type="text/javascript">
    var course =<%= course.getId()%>;
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "language": { "url": "/datatable/lang/dataTables.<%=session.getValue("locale").toString()%>" },
            "sAjaxSource": "/api/professor/students",
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
                            return ' <a href=\"/professor/mark/create?id=' + row.id + '&course=' + course + '\"><img src="/content/images/add-20.png"/></a> ';
                        else
                            return data + ' <a href=\"/professor/mark/edit?id=' + row.id + '&course=' + course + '\"><img src="/content/images/pen-20.png"/></a>' +
                                    '<a href=\"/professor/mark/delete?id=' + row.id + '&course=' + course + '\"><img src="/content/images/delete-20.png"/></a>';
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
<jsp:include page="../Menu.jsp"/>
<div id="container">
    <br/>
    <br/>
    <h2><%= course.getName()%>
    </h2>
    <h5><%= course.getDescription()%>
    </h5>
    <br/>
    <h4><fmt:message bundle="${loc}" key="students"/></h4>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th><fmt:message bundle="${loc}" key="student_name"/></th>
            <th><fmt:message bundle="${loc}" key="mark"/></th>
        </tr>
        </thead>
    </table>
</div>
</div>
</body>
</html>
