package pl.altkom.web;

import pl.altkom.DAO.ClientDataDAO;
import pl.altkom.DAO.ClientDataDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/displayClient")
public class DisplayClientsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            List list =  dao.readClientsData( getServletContext().getInitParameter("dataSource"));
            PrintWriter pw = resp.getWriter();
            pw.println("<HTML><HEAD>");
            pw.println("<TITLE>lista klientow</TITLE>");
            pw.println("<table border=\"solid\">");
            for(Object o : list){
                Client c = (Client)o;
                pw.println("<tr><td>"+c.getFirstName()+"</td>");
                pw.println("<td>"+c.getLastName()+"</td>");
                pw.println("<td>"+c.getAge()+"</td></tr>");

            }
            pw.println("</table>");
            pw.println("</HEAD><BODY>");
            pw.println("</BODY></HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
