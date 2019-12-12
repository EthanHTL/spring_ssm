<%--
  Created by IntelliJ IDEA.
  User: 海神阁
  Date: 2019/12/5
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <label>文件上传</label><br>
    <form action="fileUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" ><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
