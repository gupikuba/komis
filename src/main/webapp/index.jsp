<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Komis samochodowy</title>
    <style>
        ul{list-style-type: none;padding: 0;}
        li{float:left; padding:15px;}
    </style>
</head>
<body>
<br><h1 align="center">Witaj w komisie samochodowym</h1>
<h2>Menu:</h2>
<ul>
    <li><b><a style="text-decoration:none" href="/Komis/makeForm.html">Formularz</a></b></li>
    <li><b><a style="text-decoration:none" href = "/Komis/userForm.jsp">Dodaj użytkownika</a></li>
    <li><b><a style="text-decoration:none" href = "clients">Klienci</a></li>

<div style="position:absolute; bottom:5px">
<h4>Liczba aktywnych uzytkownikow <%out.print(" ( "+pl.altkom.web.SessionCounter.getCounter()+" )<br>");%></h4>
</div>
</body>
</html>
