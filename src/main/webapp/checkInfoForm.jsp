<%@ page import="java.util.Map" %><%--
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

        <jsp:useBean id="car" class="pl.altkom.web.CarBean" scope="session"/>
        <%--to jest to swamo co
        <jsp:setProperty name="car" property="make" param="make" jesli nazwa property jest taka sama
        nie trzeba param;
        <jsp:setProperty name="car" property="type" param="type"/> i tak dalej--%>
        <jsp:setProperty name="car" property="*"/>
        <h3>sprawdz czy dane sa poprawne</h3>
        <table border="solid">
            <tr>
                <th>marka</th>
                <td><jsp:getProperty name="car" property="make"/></td>
            </tr>
            <tr>
                <th>typ</th>
                <td><jsp:getProperty name="car" property="type"/></td>
            </tr>
            <tr>
                <th>rok produkcji</th>
                <td><jsp:getProperty name="car" property="year"/></td>
            </tr>
            <tr>
                <th>przebieg</th>
                <td><jsp:getProperty name="car" property="milage"/></td>
            </tr>
            <tr>
                <th>pojemnosc</th>
                <td><jsp:getProperty name="car" property="capacity"/></td>
            </tr>
        </table>
    <br><br>
        <%--tego nie trzeba teraz bo mamy w sesji obiekt car i potem tylko trzeba go dostac z r
        req.getSession.getAttribute("car");
        <form action="saveCar" method="post">
            <%-- <input type="hidden" name="brand" value='<%= request.getParameter("brand")%>'>
            <input type="hidden" name="type" value='<%= request.getParameter("type")%>'>
            <input type="hidden" name="year" value='<%= request.getParameter("year")%>'>
            <input type="hidden" name="milage" value='<%= request.getParameter("milage")%>'>
            <input type="hidden" name="capacity" value='<%= request.getParameter("capacity")%>'>
            <%Map<String,String[]>map = (Map<String,String[]>)request.getParameterMap();%>
               <% for(Map.Entry<String, String[]> e : map.entrySet()){%>
            <input type="hidden" name = "<%out.print(e.getKey());%>" value="<%out.print(e.getValue()[0]);%>">
                  <% }%>
        <input type="submit" value="dodaj samochod">
        </form>--%>
        <form action="carInfoForm.jsp">
            <input type="submit" value="edytuj">
        </form>
        <form action="saveCar" method="post">
            <input type="submit" value="dodaj samochod">
        </form>
        <%@include file="comany_address.jsp"%>
</body>
</html>
