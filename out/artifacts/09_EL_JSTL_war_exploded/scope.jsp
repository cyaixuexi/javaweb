<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/29
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContext");
        pageContext.setAttribute("key2","pageContext");
        request.setAttribute("key2","request");
        session.setAttribute("key2","session");
        application.setAttribute("key2","application");
    %>
    ${requestScope.key2}
</body>
</html>
