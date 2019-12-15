<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edytuj</title>
</head>
<body>
    <%String[] data = request.getParameter("client").split(" ");%>
    <h3>Edytuj klienta</h3>
    <form action="editClient">
        <input type="hidden" name="id" value = "<%=data[0]%>">
        Imię: <input type="text"  value = <%=data[1]%> name="firstName"> <br>
        Nazwisko: <input type="text" value = <%=data[2]%> name="lastName"> <br>
        Wiek: <select name="age" >
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
        <input type="submit" value="Edytuj">
    </form>
</body>
</html>
