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
<form action="saveClient" method="post">
    Imię: <input type="text" name="firstName"> <br>
    Nazwisko: <input type="text" name="lastName"> <br>
    Wiek: <select name="age">
    <%for(int i = 1; i<=100; i++){%>
    <%out.print("<option>"+i+"</option>");%>
    <%}%>
</select> <br>
    Region: <select name="region">
    <option>Polska</option>
    <option>Niemcy</option>
    <option>Czechy</option>
    <option>Francja</option>
    <option>Holandia</option>
</select><br>
    <input type="radio" name="sex" value="MALE"> Mężczyzna <br>
    <input type="radio" name="sex" value="FEMALE"> Kobieta <br>
    <input type="submit" value="Utwórz użytkownika">
</form>
</body>
</html>
