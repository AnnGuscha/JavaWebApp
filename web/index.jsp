<%@ page import="manager.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="<%=Locale.DEFAULT.toString()%>"/>
<fmt:setBundle basename="properties.resfile" var="loc"/>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="My Application"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link href="offcanvas.css" rel="stylesheet">
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>
    </div>
</div>
<div class="container">
    <br><br><br>
    <h4><p>При ргистрации пользователь по умолчанию становится студентом. </p>

        <p>Изменить его роль может только другой пользователь с правами администратора.</p>
    </h4>
    <br/>

    <p>Тестовые профили:</p>

    <div class="form-group col-xs-4">
        <div>
            Администратор
            <br/>
            Логин: admin
            <br/>
            Пароль: 1
        </div>
        <br/>

        <div>
            Преподаватель
            <br/>
            Логин: professor
            <br/>
            Пароль: 1
        </div>
        <br/>

        <div>
            Студент
            <br/>
            Логин: student
            <br/>
            Пароль: 1
        </div>
        <br/>

        <a href="/login" type="button" class="btn btn-lg btn-primary  btn-md btn-block">
            <fmt:message bundle="${loc}" key="login"/>
        </a>
        <a href="/registr" type="button" class="btn btn-lg btn-primary  btn-md btn-block">
            <fmt:message bundle="${loc}" key="registration"/>
        </a>
    </div>
</div>
</body>
</html>
