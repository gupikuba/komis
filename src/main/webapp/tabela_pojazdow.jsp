<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 04.01.2020
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource dataSource="jdbc:komis" var="db" />
<sql:query var="dane" dataSource="${db}">
    <jsp:useBean id="car" class="pl.altkom.web.CarBean" scope="session"/>
    SELECT * FROM pojazd
</sql:query>
<table border="solid" align="center">
    <tr>
        <th>marka</th>
        <th>typ</th>
        <th>rok</th>
        <th>przebieg</th>
        <th>pojemnosc</th>

    </tr>

<c:forEach var="row" items="${dane.rows}">
    <tr>
    <td><c:out value="${row.marka}"/></td>
    <td><c:out value="${row.typ}"/></td>
    <td><c:out value="${row.rok}"/></td>
    <td><c:out value="${row.przebieg}"/></td>
    <td><c:out value="${row.pojemnosc}"/></td>
        <td>
            <form action="carInfoForm.jsp">
                <input type="hidden" value="${row}">
                <input type="submit" value="edytuj">
            </form>
        </td>
    </tr>
</c:forEach>

</table>
</body>
</html>
