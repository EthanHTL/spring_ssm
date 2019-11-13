<%--
  Created by IntelliJ IDEA.
  User: 海神阁
  Date: 2019/10/31
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>客户信息录入</title>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/userController/addUser">
        用户信息：<input type="text" name="username"><br><br>
        PassWord:<input type="password" name="password"><br><br>
        用户性别：<input type="radio" name="sex" value="男">男
                 <input type="radio" name="sex" value="女">女<br><br>
        <input type="submit" value="提交">
    </form>


</body>
</html>
