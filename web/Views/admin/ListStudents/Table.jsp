<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../../Header.jsp"/>
<fmt:setLocale value="<%=((Locale)session.getValue(\"locale\")).toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "language": {"url": "/datatable/lang/dataTables.<%=session.getValue("locale").toString()%>"},
            "sAjaxSource": "/api/admin/liststudents",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + "\" href=\"/admin/liststudents/edit/" + data + '\" > <img src="/content/images/pen-20.png"/></a> |' +
                                    //'<a href=\"Details/' + data + '\">Details</a> |' +
                                ' <a href=\"/admin/liststudents/delete/' + data + '\"><img src="/content/images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
            ],
            "columns": [
                {"data": "id"},
                {"data": "idCourse"},
                {"data": "idStudent"}
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
            window.location.href = "details/" + href;

        });
    });
</script>
<body>
<jsp:include page="../../Menu.jsp"/>
<div id="demo">
    <h2><fmt:message bundle="${loc}" key="list_students"/></h2>
    <p>
        <a href="/admin/liststudents/create"><fmt:message bundle="${loc}" key="create"/></a>
    </p>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th><fmt:message bundle="${loc}" key="course"/></th>
            <th><fmt:message bundle="${loc}" key="student"/></th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>