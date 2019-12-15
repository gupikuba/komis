package pl.altkom.web;

import pl.altkom.DAO.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/deleteClient")
public class DeleteClient extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] names = req.getParameter("client").split(" ");
        System.out.println(names[0]);
        ClientDataDAOImpl dao = new ClientDataDAOImpl();
        try{
            dao.removeClient(names[0], names[1],ds);
        }catch(Exception e){
            throw new ServletException("cannot delete user");
        }
        req.getRequestDispatcher("clients").forward(req, resp);
    }
}
