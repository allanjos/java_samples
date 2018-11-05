import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet(urlPatterns={"/test"})
public class ServletTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.append("<h1>Servlet</h1>");

        writer.append("<a href=\"index.jsp\">Go to main page</a>");

        writer.append("<br/><br/>");

        writer.append("Served at: " + request.getContextPath());
    }
}
