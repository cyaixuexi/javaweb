<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/29
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<c:set></c:set>
        作用：set标签可以往域中保存数据

        域对象.setAttribute（key,value）;
        scope 属性设置保存到那个域中
            page表示PageContext域（默认值）
            request表示request域
            session表示session域
            application表示application域
        var属性设置key是多少
        value属性设置值
    --%>
    保存之前:${requestScope.abc} <br>
    <c:set scope="request" var="abc" value="abcvalue"/>
    保存之后:${requestScope.abc} <br>

    <hr>

    <%-- <c:if></c:if>
            if标签用来判断

            test属性表示判断的条件（使用EL表达式输出）
    --%>
    <c:if test="${12==12}">
        <h1>12等于12</h1>
    </c:if>
    <c:if test="${12!=12}">
        <h1>12不等于12</h1>
    </c:if>
    <hr>

    <%-- <c:choose><c:when test=""><c:otherwise></c:otherwise></c:when></c:choose>
            作用：多路判断。跟switch...case...default非常接近

            choose标签开始选择判断
            when标签表示每一种判断情况
                test属性表示当前这种判断情况的值
            otherwise标签表示剩下的情况

            <c:choose><c:when test=""><c:otherwise>标签使用是需要注意的点：
                1 标签里不能使用html注释，要使用jsp注释
                2 when 标签的父标签一定是choose标签
            --%>
    <%
        request.setAttribute("height",168);
    %>
    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h2>能找对象</h2>
        </c:when>
        <c:when test="${requestScope.height > 170}">
            <h2>也能找对象，就是不好找</h2>
        </c:when>
        <c:otherwise>
            <h2>剩下小于170，不好找对象</h2>
        </c:otherwise>
    </c:choose>


</body>
</html>
