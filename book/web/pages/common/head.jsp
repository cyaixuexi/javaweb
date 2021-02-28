<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/30
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basepath = request.getScheme()
        +"://"
        +request.getServerName()
        +":"
        +request.getServerPort()
        +request.getContextPath()
        +"/";

    pageContext.setAttribute("basepath",basepath);
%>
<!--写base标签，永远固定相对路径调转的结果-->
<base href="<%=basepath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>