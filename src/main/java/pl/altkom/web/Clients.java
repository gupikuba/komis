package pl.altkom.web;

import pl.altkom.DAO.ClientDataDAO;
import pl.altkom.DAO.ClientDataDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clients")
public class Clients extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            List list =  dao.readClientsData( getServletContext().getInitParameter("dataSource"));
            req.setAttribute("list", list);
            req.getRequestDispatcher("clients.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
