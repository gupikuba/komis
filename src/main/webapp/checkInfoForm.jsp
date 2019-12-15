<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sprawdz czy dane sa poprawne</title>
</head>
<body>
        <h3>sprawdz czy dane sa poprawne</h3>
        <table border="solid">
            <tr>
                <th>marka</th>
                <td><%=request.getParameter("brand")%></td>
            </tr>
            <tr>
                <th>typ</th>
                <td><%=request.getParameter("type")%></td>
            </tr>
            <tr>
                <th>rok produkcji</th>
                <td><%=request.getParameter("year")%></td>
            </tr>
            <tr>
                <th>przebieg</th>
                <td><%=request.getParameter("milage")%></td>
            </tr>
            <tr>
                <th>pojemnosc</th>
                <td><%=request.getParameter("capacity")%></td>
            </tr>
        </table>
</body>
</html>
