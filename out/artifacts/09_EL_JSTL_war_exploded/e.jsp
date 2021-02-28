<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/28
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
//        1 值为null值的时候为空
        request.setAttribute("emptyNull",null);
//        2 值为空串的时候为空
        request.setAttribute("emptyStr","");
//        3 值为Object类型数组 长度为0的时候
        request.setAttribute("emptyArr",new Object[]{});
//        4 list集合 元素个数为0的时候
        List<String > list = new ArrayList<>();
        request.setAttribute("emptyList",list);
//        4 map集合 元素个数为0的时候
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("emptyMap",map);
    %>
    ${empty emptyNull} <br>
    ${empty emptyStr} <br>
    ${empty emptyArr} <br>
    ${empty emptyList} <br>
    ${empty emptyMap} <br>

    ${12==12?"我真帅":"你骗人"}

</body>
</html>
