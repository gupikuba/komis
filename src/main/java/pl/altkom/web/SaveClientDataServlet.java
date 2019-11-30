package pl.altkom.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class SaveClientDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client client = new Client();
        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        client.setAge(Integer.valueOf(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.saveClientData(client, getServletContext().getInitParameter("dataSource"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>succes</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("Udalo Ci sie dodac uzytkownika do bazy danych");
        pw.println("<br><br>dodaj kolejnego uzytkownika<br>" +
                "<a href = /Komis/userForm.html>dodaj uzytkownika</a>");
        pw.println("</BODY></HTML>");

    }
}
