<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/13/2015
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../Header.jsp"/>

<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "api/professor",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + "\" href=\"professor/edit/" + data + '\" > <img src="/Content/Images/pen-20.png"/></a> |' +
                                    //'<a href=\"Details/' + data + '\">Details</a> |' +
                                ' <a href=\"professor/delete/' + data + '\"><img src="/Content/Images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
            ],
            "columns": [
                {"data": "id"},
                {"data": "firstName"},
                {"data": "surName"},
                {"data": "patronymicName"}
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
<jsp:include page="../Menu.jsp"/>

<div id="demo">
    <h2>Professors</h2>

    <p>
        <a href="professor/create">Create</a>
    </p>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic Name</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>