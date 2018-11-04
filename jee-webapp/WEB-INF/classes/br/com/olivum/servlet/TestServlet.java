package br.com.olivum.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/test", "/test/"})
public class TestServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");

        out.println("<head>");
        out.println("<title>" + "TestServlet" + "</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>TestServlet</h1>");

        out.println("<a href=\"index.html\">Go to index.html</a>");

        out.println("</body>");

        out.println("</html>");
    }
}
