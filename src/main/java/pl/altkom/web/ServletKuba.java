package pl.altkom.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hellokuba")
public class ServletKuba extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>HelloKuba</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>Hello Kuba!</H3>");
        pw.println("</BODY></HTML>");
    }
}
