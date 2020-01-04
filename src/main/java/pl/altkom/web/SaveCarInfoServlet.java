package pl.altkom.web;

import pl.altkom.DAO.CarInfoDAO;
import pl.altkom.DAO.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/saveCar")
public class SaveCarInfoServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource ds;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CarBean carBean = new CarBean();
//        carBean.setMake(req.getParameter("make"));
//        carBean.setType(req.getParameter("type"));
//        carBean.setYear(Integer.valueOf(req.getParameter("year")));
//        carBean.setCapacity(req.getParameter("capacity"));
//        carBean.setMilage(req.getParameter("milage"));
        CarBean carBean = (CarBean) req.getSession().getAttribute("car");
        CarInfoDAO cIDAO = new CarInfoDAOImpl();

        try{
            cIDAO.saveCarInfo(carBean,ds);
        }catch(Exception e){
            throw new ServletException("cannot add car");
        }
    }
}
