package pl.altkom.web;

import pl.altkom.DAO.ClientDataDAO;
import pl.altkom.DAO.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/saveClient")
public class SaveClientDataServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;
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
            dao.saveClientData(client, ds);
            req.setAttribute("client",client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>succes</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<h3>Udalo Ci sie dodac uzytkownika do bazy danych</h3>");
        Object counter = getServletContext().getAttribute("savedClientCounter");
        if(counter!=null)
            pw.println("<div style=\"position:absolute;bottom:15px\">dodano: "+counter.toString() + " uzytkownikow</div>");
        pw.println("<ul>");
        pw.println("<li><a style=\"text-decoration:none\" href = /Komis/userForm.jsp>Dodaj kolejnego uzytkownika</a></li>");
        pw.println("<li><a style=\"text-decoration:none\" href= /Komis>Strona glowna</a></li>");
        pw.println("</ul>");
        pw.println("</BODY></HTML>");

    }
}
