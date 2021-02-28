<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/2/2
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/13_cookie_session/loginServlet" method="get">
        用户名:<input type="text" name="username" value="${cookie.username.value}" > <br>
        密 码:<input type="text" name="password" value=""> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
