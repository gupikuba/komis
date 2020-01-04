<%@ page import="java.util.Arrays" %>
<%@ page import="pl.altkom.web.CarBean" %><%--
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
    <%-- to auto jest juz zmienna i mozna jej uzuwac

    <%CarBean auto = new CarBean();%>
    <%CarBean temp = (CarBean) session.getAttribute("auto");%>
    <%if(temp!=null)auto=temp;%>

    <jsp:useBean id="autko" class="pl.altkom.web.CarBean" scope="session">
    <% autko.setType(""); %>
    <% autko.setYear(2019); %>
    <% autko.setMake(makes.get(0)); %>
    <% autko.setCapacity("1"); %>
    <% autko.setDistance("0"); %>
</jsp:useBean>

<% CarBean auto = (CarBean) session.getAttribute("autko"); %>
--%>
    <jsp:useBean id="car" class="pl.altkom.web.CarBean" scope="session">
        <%--wykonuje sie tylko gdy nie ma jeszcze car w sesji--%>
        <%car.setType("");
        car.setYear(0);
        car.setMake("");
        car.setCapacity("");
        car.setMilage("");%>
    </jsp:useBean>
    <%CarBean auto = (CarBean)session.getAttribute("car");%>
            <form action="checkInfoForm.jsp" method="post">
        marka<select name="make">
            <%
                Arrays.sort(brands);
                for(String s : brands){
                    if(auto.getMake().equals(s))
                        out.print("<option selected=\"selected\">"+s+"</option>");
                    else
                        out.print("<option>"+s+"</option>");
            }
                %>
        </select><br>
        typ<select name="type">
            <%
                Arrays.sort(types);
                for(String s :types){
                    if(auto.getType().equals(s))
                        out.print("<option selected=\"selected\">"+s+"</option>");
                    else
                        out.print("<option>"+s+"</option>");
            }
            %>
        </select><br>
        rok<select name="year">
        <%for(int i = 1970; i<=2019; i++)
            if(auto.getYear()==i)
                out.print("<option selected=\"selected\">"+i+"</option>");
            else
                out.print("<option>"+i+"</option>");
        %>
    </select><br>
        przebieg<select name="milage">
        <%
            for(int i = 0, j = 20000; i <=300000; i+=20000,j+=20000)
                if(auto.getMilage().equals(i+" - "+j))
                    out.print("<option selected=\"selected\">"+i+" - "+j+" km</option>");
                else
                    out.print("<option>"+i+" - "+j+" km</option>");
        %>
    </select><br>
        pojemność<select name="capacity">
        <%
            for(int i = 1000, j = 1500; i <=3000; i+=500, j+=500)
                if(auto.getCapacity().equals(i+" - "+j))
                    out.print("<option selected=\"selected\">"+i+" - "+j+" cm3</option>");
                else
                    out.print("<option>"+i+" - "+j+" cm3</option>");

        %>
    </select><br>
        <input type="submit" value="wyslij">
    </form>
    <br><br>
    <%@include file="comany_address.jsp"%>
</body>
</html>
