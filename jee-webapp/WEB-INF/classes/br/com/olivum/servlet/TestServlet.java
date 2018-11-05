package br.com.olivum.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;

@WebServlet(urlPatterns={"/test"})
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

        out.println("<br/><br/>");

        ServletContext application = getServletConfig().getServletContext();

        out.println("Application servlet context name: " + application.getServletContextName());
        out.println("<br/>");
        out.println("Application context path: " + application.getContextPath());
        out.println("<br/>");
        out.println("Remote address: " + request.getRemoteAddr());

        if (request.getRemoteAddr().equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostAddress = inetAddress.getHostAddress();

            out.println("<br/>");
            out.println("Host address: " + hostAddress);
        }

        out.println("</body>");

        out.println("</html>");
    }
}
