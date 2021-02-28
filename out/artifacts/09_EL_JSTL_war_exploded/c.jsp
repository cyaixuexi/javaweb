<%@ page import="com.cy.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 羽哥
  Date: 2021/1/28
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("我好帅");
        person.setPhones(new String[]{"123456","123","456"} );

        List<String> cities = new ArrayList<String >();
        cities.add("北京");
        cities.add("上海");
        cities.add("广州");
        person.setCities(cities);

        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>

    输出person：${person} <br>
    输出person的name属性值：${person.name} <br>
    输出person的phones集合属性值：${person.phones[0]} <br>
    输出person的cities集合属性值：${person.cities} <br>
    输出person的cities集合中个别元素属性值：${person.cities[1]} <br>
    输出person的map集合属性值：${person.map} <br>
    输出person的map集合中某个key的属性值：${person.map.key1} <br>

    输出person的age属性值：${person.age} <br>

</body>
</html>
