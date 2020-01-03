<%--
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
<%!String[] regions = pl.altkom.web.KomisData.getRegions();%>
<br><br><b>Podaj dane klienta:<b><br><br>
<form action="saveClient" method="post">
    Imię:     <input type="text" name="firstName"> <br><br>
    Nazwisko: <input type="text" name="lastName"> <br><br>
    Wiek: <select name="age">
    <%for(int i = 17; i<=100; i++){%>
    <%out.print("<option>"+i+"</option>");%>
    <%}%>
</select> <br><br>
    Region: <select name="region">
    <%for(String s : regions){%>
    <option><%=s%></option>
    <%}%>

</select><br><br>
    <input type="radio" name="sex" value="MALE"> Mężczyzna <br>
    <input type="radio" name="sex" value="FEMALE"> Kobieta <br><br>
    <input type="submit" value="Utwórz użytkownika">
</form>
</body>
</html>
