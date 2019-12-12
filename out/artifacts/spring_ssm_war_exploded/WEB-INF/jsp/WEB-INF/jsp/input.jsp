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
        用户信息：<input type="text" id="username" name="username"><br><br>
        PassWord:<input type="password" id="password" name="password"><br><br>
        用户性别：<input type="radio"  name="sex" value="男">男
                 <input type="radio"  name="sex" value="女">女<br><br>
        <input type="submit" id="anniu" onclick="save()" value="提交">




<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" >
    function save(){
        // var fromdata = new FormData(document.getElementById("user"));
        var username =$("#username").val();
        var password = $("#password").val();
        var sex = $("input[name='sex']:checked").val();
        $.post(
            "${pageContext.request.contextPath}/userController/addUser",
            {"username":username,"password":password,"sex":sex},
            function(data){
                alert(data);
                window.location.href= "${pageContext.request.contextPath}/userController/show"
            }
        );

    }

</script>

</body>
</html>
