package pl.altkom.web;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/delete_by_id")
public class DeleteClientByID extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));

        ClientDataDAOImpl dao = new ClientDataDAOImpl();
        try{
            dao.removeClient(id,ds);
        }catch(Exception e){
            throw new ServletException("cannot delete user");
        }
        req.getRequestDispatcher("clients").forward(req, resp);
    }
}
