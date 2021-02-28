<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/28
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息 <br>
    主题内容 <br>
    <%--<%@include file=""%> 就是静态包含
            file 属性指定你要包含的jsp页面路径
            地址中的第一个 / 斜线表示 http://ip:port/工程路径/     映射到代码的web目录

            静态包含的特点：
                1 静态包含不会翻译被包含的jsp页面
                2 静态包含其实是把包含的jsp页面的代码拷贝到包含位置执行输出
    --%>
    <%--
        <%@include file="/include/footer.jsp"
    --%>

    <%--<jsp:include page=""></jsp:include>     这是动态包含
    page 属性是指定 你要包含的jsp页面的路径
    动态包含也可以像静态包含一样，那被包含的内容执行输出到包含位置

    动态包含的特点
        1 动态包含会把包含的jsp页面也翻译成java代码
        2 动态包含底层代码使用如下 代码去调用被包含的jsp页面输出执行。
        JspRuntimeLibrary.include(request,response,"/include/footer.jsp",out,false);
        3 动态包含 还可以传递参数  
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="bbj"/>
        <jsp:param name="password" value="root"/>
    </jsp:include>


    %>
</body>
</html>
