<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 12/8/2015
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="My Application"/>
    <link rel="Stylesheet" href="./Content/StyleTable.css" type="text/css"/>

</head>
<body style="background-image: url(/Content/Images/partners.jpg); background-position: center;background-repeat: no-repeat;">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            @Html.ActionLink("Компьютерная фирма", "Index", "Home", null, new { @class = "navbar-brand" })
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li>@Html.ActionLink("Главная", "Index", "Home")</li>
                <li>@Html.ActionLink("Сведения", "About", "Home")</li>
                <li>@Html.ActionLink("Контаты", "Contact", "Home")</li>
            </ul>
            @Html.Partial("_LoginPartial")
        </div>
    </div>
</div>
<link href="/Content/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
<script src="Scripts/Home/jquery.dataTables.min.js" type="text/javascript"></script>
<script type="text/javascript">

    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "AjaxHandler",
            "bProcessing": true,
            "bRetrieve": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + '\" href=\"Edit/' + data + '\" > <img src="/Content/Images/pen-20.png"/></a> |' +
                                    //'<a href=\"Details/' + data + '\">Details</a> |' +
                                ' <a href=\"Delete/' + data + '\"><img src="/Content/Images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                }
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
<div class="container body-content">
    <div id="container">
        <div id="demo">
            <h2>Должности</h2>

            <p>
                @Html.ActionLink("Добавить", "Create")
            </p>
            <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th></th>
                    <th>Название</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>

    <hr/>
    <footer>
        <p>&copy; @DateTime.Now.Year - Моё Приложение</p>
    </footer>
</div>
</body>
</html>
