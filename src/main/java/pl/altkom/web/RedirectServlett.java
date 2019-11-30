package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RedirectServlett extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("marka");
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<br><br><h1>wybrales samochod "+str+"</h1>");
        pw.println("</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("marka");
        PrintWriter pw = resp.getWriter();
//        String name = req.getParameter("name");
        pw.println("<HTML><HEAD>");
       pw.println("<TITLE>hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<br><br><h1>wybrales samochod "+str+"</h1>");
        pw.println("za chwile nastapi przekierowanie na strone producenta");
        pw.println("</BODY></HTML>");

        //pw.println("<meta http-equiv=\"Refresh\" content=\"5;url=http://www."+str+".com\">");

    }
}
