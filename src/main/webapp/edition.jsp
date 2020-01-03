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
    <%String[] regions = pl.altkom.web.KomisData.getRegions();%>
    <h3>Edytuj klienta</h3>
    <form action="editClient">
        <input type="hidden" name="id" value = "<%=data[0]%>">
        Imię: <input type="text"  value = <%=data[1]%> name="firstName"> <br>
        Nazwisko: <input type="text" value = <%=data[2]%> name="lastName"> <br>
        Wiek: <select name="age" >
        <%for(int i = 17; i<=100; i++){%>
        <%String selected = "";%>
        <%if(i==Integer.valueOf(data[3]))selected = "selected=\"selected\"";%>
        <option <%=selected%>><%=i%></option>
        <%}%>
    </select> <br>
        Region: <select name="region">
        <%for(String s : regions){%>
        <%String selected = "";%>
        <%if(data[4].equals(s)) selected = "selected=\"selected\"";%>
        <option <%=selected%>><%=s%></option>
        <%}%>

    </select><br>
        <input type="radio" name="sex" value="MALE"
        <%if(data[5].equals("mezczyzna"))out.print("checked=\"checked\"");%>> Mężczyzna <br>
        <input type="radio" name="sex" value="FEMALE"
        <%if(data[5].equals("kobieta"))out.print("checked=\"checked\"");%>> Kobieta <br>
        <input type="submit" value="Edytuj">
    </form>

</body>
</html>
