<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informacje o samochodzie</title>
</head>
<body>
    <%! String[] brands = {"Fiat", "Opel", "Audi", "Toyota", "Mazda", "Renault", "Honda", "Ford", "Citroen","Volvo","BMW"};
        String[] types = {"sedan", "kombi", "hatch-back", "kabriolet", "minivan", "pickup"};
    %>
    <form action="checkInfoForm.jsp" method="post">
        marka<select name="brand">
            <%
                Arrays.sort(brands);
                for(String s : brands){
                out.print("<option>"+s+"</option>");
            }
                %>
        </select><br>
        typ<select name="type">
            <%
                Arrays.sort(types);
                for(String s :types){
                out.print("<option>"+s+"</option>");
            }
            %>
        </select><br>
        rok<select name="year">
        <%for(int i = 1970; i<=2019; i++)
            out.print("<option>"+i+"</option>");
        %>
    </select><br>
        przebieg<select name="milage">
        <%
            for(int i = 0, j = 20000; i <=300000; i+=20000,j+=20000)
            out.print("<option>"+i+" - "+j+" km</option>");
        %>
    </select><br>
        pojemność<select name="capacity">
        <%
            for(int i = 1000, j = 1500; i <=3000; i+=500, j+=500)
                out.print("<option>"+i+" - "+j+" cm3</option>");
        %>
    </select><br>
        <input type="submit" value="wyslij">
    </form>
    <br><br>
    <%@include file="comany_address.jsp"%>
</body>
</html>
