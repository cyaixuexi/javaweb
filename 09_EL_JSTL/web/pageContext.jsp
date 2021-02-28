<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/29
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    request.getScheme() 他可以获取请求的协议
    request.getserverName() 他可以获取请求的服务器ip或域名
    request.getserverrPort() 他可以获取请求的服务器端口
    request.getserverrPort() 他可以获取请求的服务器端口
    request.getContextPath()   获取当前工程路径
    request.getMethod() 获取当前请求方式
    request.getRemoteHost() 获取客户端ip地址
    session.getId() 获取回话的唯一标识
    --%>
    <%=session.getId()%> <br>
    <hr>
    1 协议 ： ${pageContext.request.scheme} <br>
    2 服务器ip:${pageContext.request.serverName} <br>
    3 服务器端口 :${pageContext.request.serverPort}<br>
    4 获取工程路径:${pageContext.request.contextPath} <br>
    5 获取请求方式：${pageContext.request.method} <br>
    6 获取客户端ip地址:${pageContext.request.remoteHost} <br>
    7 获取回话的id编号:${pageContext.session.id} <br>
</body>
</html>
