<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/28
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","值");
    %>
    表达式脚本输出key的值：<%=request.getAttribute("key1")%><br>
    EL表达式输出key的值：${key1}
</body>
</html>
