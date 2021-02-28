<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cy.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/29
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--遍历1到10，输出
        begin属性设置开始的索引
        end属性设置结束的索引
        var属性表示循环的变量(也是当前正在遍历到的数据)
    --%>
    <table border="1">
        <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
        </c:forEach>
    </table>
    <hr>
    <%--2.遍历Object数组
            for(Object  item : arr)
            item 表示遍历的数据源（遍历的集合）
            var 表示当前遍历到的数据
    --%>
     <%
         request.setAttribute("arr",new String[]{"123","456","789"});
     %>
     <c:forEach items="${requestScope.arr}" var="i">
         ${i}
     </c:forEach>
    <hr>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        /*for (Map.Entry<String,Object>  entry :map.entrySet()){
        }*/
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
         <h1> ${entry.key} = ${entry.value}</h1>
    </c:forEach>

    <hr>

<%--    4  遍历list集合---list中存放student类 有属性：编号，用户名，密码，年龄，电话信息--%>
    <%
        List<Student> studentList = new ArrayList<>();
        for (int i=1;i<=10;i++){
            studentList.add(new Student(i,"username"+i,"password"+i,18+i,"phont"+i));
        }
        request.setAttribute("stus",studentList);
    %>
    <%--
        item 表示遍历的数据源（遍历的集合）
        begin属性设置开始的索引
        end属性设置结束的索引
        var属性表示循环的变量(也是当前正在遍历到的数据)
        step 属性表示遍历的步长值
        varStatus 属性表示当前遍历的数据的状态
    --%>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
    <c:forEach begin="2" end="7" step="2" varStatus="" items="${requestScope.stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>删除、修改</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
