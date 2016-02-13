<%@ page import="manager.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>
<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "language": {"url": "/datatable/lang/dataTables.<%=session.getValue("locale").toString()%>"},
            "sAjaxSource": "/api/student/courses",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a href=\"/api/student/unsubs/' + data + '\">Unsubscribe</a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
            ],
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "nameProfessor"},
                {"data": "description"},
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
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<body>
<jsp:include page="../Menu.jsp"/>
<div id="demo">
    <h2><fmt:message bundle="${loc}" key="student_courses"/></h2>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th><fmt:message bundle="${loc}" key="course_name"/></th>
            <th><fmt:message bundle="${loc}" key="professor"/></th>
            <th><fmt:message bundle="${loc}" key="description"/></th>
            <th><fmt:message bundle="${loc}" key="mark"/></th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>

