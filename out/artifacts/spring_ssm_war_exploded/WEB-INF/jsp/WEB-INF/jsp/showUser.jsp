<%--
  Created by IntelliJ IDEA.
  User: 海神阁
  Date: 2019/11/7
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../../static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/bootstrap-3.3.7-dist/table/bootstrap-table.min.css" rel="stylesheet">

</head>
<body>
<%--    <c:forEach items="${userList}" var="item" varStatus="id">--%>
<%--        <option value="${item.id}">${item.toString()} </option>--%>
<%--    </c:forEach>--%>

    <table id="table"></table>



    <script src="../../static/js/jquery-3.4.1.min.js"></script>
    <script src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../../static/bootstrap-3.3.7-dist/table/bootstrap-table.min.js"></script>
    <script src="../../static/bootstrap-3.3.7-dist/table/bootstrap-table-zh-CN.min.js"></script>
    <script>
        $('#table').bootstrapTable({
            url: "/userController/findAll",
            pagination: true,
            search: true,
            columns: [{
                field: 'id',
                title: 'Item ID'
            }, {
                field: 'username',
                title: 'Name'
            }, {
                field: 'password',
                title: 'PassWord'
            }, {
                field: 'sex',
                title: 'Sex'
            }]
        })

    </script>

</body>
</html>
