package pl.altkom.web;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/editClient")
public class EditClient extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));
        String fName = req.getParameter("firstName");
        Client client = new Client();
        client.setId(id);
        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        client.setAge(Integer.valueOf(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));


        ClientDataDAOImpl dao = new ClientDataDAOImpl();
        try{
            dao.editClient(client,ds);
        }catch(Exception e){
            throw new ServletException("cannot delete user");
        }
        req.getRequestDispatcher("clients").forward(req, resp);
    }
}
