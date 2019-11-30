package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>hello</TITLE>");
        pw.println("</HEAD><BODY>");
        if(name!=null)
            pw.println("<H1> HELLO!!! " + name+" </H!>");
        else
            pw.println("<H1> HELLO!!! </H!>");
        pw.println("<br><br><a href = /Komis/makeForm.html>formularz</a>");
        pw.println("<br><br><a href = /Komis/userForm.html>dodaj uzytkownika</a>");
        pw.println("</BODY></HTML>");

    }
}
