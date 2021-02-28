<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/29
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param} <br>
    输出请求参数username的值：${param.username} <br>
    输出请求参数password的值：${param.password} <br>
    输出请求参数username的值：${paramValues.username[0]}
    <hr>
    <hr>
    请求头【User-Agent】的值：${header["User-Agent"]}   <br>
    请求头【Connection】的值：${header["Connection"]} <br>
    请求头【User-Agent】的值：${headerValues["User-Agent"][0]} <br>
    <hr>
    获取cookie的名称：${cookie.JSESSIONID.name} <br>
    获取cookie的值：${cookie.JSESSIONID.value} <br>

    <hr>
    ${initParam} <br>
    输出&lt;Context-param&gt;username的值:${initParam.username}

</body>
</html>
