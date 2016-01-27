<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/16/2015
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../Header.jsp"/>

<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "api/student_allcourses",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        if (row.isSubscribed == true)
                            return ' <a href=\"student/unsubs/' + data + '\">Unsubscribe</a> ';
                        else
                            return ' <a href=\"student/subs/' + data + '\">Subscribe</a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
            ],
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "nameProfessor"},
                {"data": "description"}
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

<div id="demo">
    <h2>All courses</h2>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Name course</th>
            <th>Professor</th>
            <th>Description</th>
        </tr>
        </thead>
    </table>

</div>
</body>
</html>