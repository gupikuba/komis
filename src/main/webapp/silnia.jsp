<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 14.12.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="solid">
        <tr><th>liczba</th>
            <th>silnia</th>
        <tr>
    <% int n = 1;%>
    <% for(int i = 1; i < 10; i++){%>
    <% n *= i;%>
    <tr><td><%out.print(i);%></td><td><%out.print(i+"!= "+n);%></td></tr>
    <%}%>
    </table>
</body>
</html>
