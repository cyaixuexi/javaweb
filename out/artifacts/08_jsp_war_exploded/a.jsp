<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/27
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--声明脚本--%>
    <%--声明类属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>
    <%-- 声明static静态代码块--%>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>
    <%--声明类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>

  <%--  声明内部类--%>
    <%!
        public static class A{
            private Integer id = 12;
            private String abc = "abc";
        }
    %>


    <%--表达式脚本
        1 输出整型
        2 输出浮点型
        3 输出字符串
        4 输出对象
    --%>
    <%= 12%> <br>
    <%= 12.12%> <br>
    <%= "我是字符串"%>   <br>
    <%= map%>

    <%--代码脚本--%>
    <%--代码脚本======if语句--%>
    <%
        int i = 12;
        if (i==12){
            System.out.println("我真帅！");
        }else{
            System.out.println("你又骗人了！");
        }
    %>
    <%--代码脚本======for 循环语句--%>
    <table border="1" cellpadding="0">


    <%
        for (int j = 0;j<10;j++){

    %>
            <tr>
                <td>第<%=j+1%>行</td>
            </tr>
    <%
        }
    %>
    </table>
    <%--翻译后java文件中_jspService方法内的代码都可以写--%>
    <%
        String username = request.getParameter("username");
        System.out.println("用户名的请求参数是："+username);
    %>
</body>
</html>
