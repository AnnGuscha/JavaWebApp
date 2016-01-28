<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/10/2015
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>

<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "/api/admin/student",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + "\" href=\"/admin/student/edit/" + data + '\" > <img src="/content/images/pen-20.png"/></a> |' +
                                ' <a href=\"/admin/student/delete/' + data + '\"><img src="/content/images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
            ],
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "surName"},
                {"data": "patronymicName"},
                {"data": "userId"}
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
            window.location.href = "admin/student/details/" + href;

        });
    });
</script>
<body>
<jsp:include page="../Menu.jsp"/>

<div id="demo">
    <h2>Students</h2>

    <p>
        <a href="/admin/student/create">Create</a>
    </p>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic name</th>
            <th>User id</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
