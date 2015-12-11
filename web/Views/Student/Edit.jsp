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

</script>

<body>
<jsp:include page="../Menu.jsp"/>

<div id="demo">
    <h2>Students</h2>

    <form action="/api/student/edit" method=post>


                        First Name*
                        <input type="text" name="firstName" value="" size=15 maxlength=20></td>

                        Last Name*
                        <input type="text" name="lastName" value="" size=15 maxlength=20></td>

                        <input type="submit" value="Submit"> <input type="reset" value="Reset">

    </form>
</div>
</body>
</html>
