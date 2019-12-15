<%@ page import="pl.altkom.web.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj uzytkownika</title>
</head>
<body>

    <%Object o = request.getAttribute("list");%>
    <%List<Client> list = (List<Client>)o;%>
    <table border="solid" align="center">
        <tr><th>imie</th><th>nazwisko</th><th>region</th><th>wiek</th><th>plec</th></tr>
    <%for(Client c : list){%>
        <tr><td><%=c.getFirstName()%><td><%=c.getLastName()%></td><td><%=c.getRegion()%></td>
            <td><%=c.getAge()%></td><td><%=c.getSex()%></td>
        <td><form action="delete_by_id">
            <input type="hidden" name="id" value= "<%=c.getId()%>">
        <input type="submit" value="usuń"></form></td>
        <td><form action="edition.jsp">
            <input type="hidden" name="client" value= "<%=c.getData()%>">
            <input type="submit" value="edytuj"></form></td></tr>
    <%}%>
    </table>
</body>
</html>
