package br.com.olivum.banking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        response.getWriter().append("Login<br/>\n");
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if (request.getParameter("username") == null || request.getParameter("password") == null) {
            response.getWriter().append("Login<br/>\n");
            response.getWriter().append("Invalid parameters.");

            return;
        }

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("login: " + userName);
        System.out.println("password: " + password);

        PrintWriter out = response.getWriter();

        // Login success
        if (!userName.isEmpty() && !password.isEmpty()) {
            HttpSession session = request.getSession();

            session.setAttribute("username", userName);

            out.println("<h3>Login Success</h3>");
            out.println("Total Active Session: " + request.getServletContext().getAttribute("activeSessions"));
            out.println("<br/>Current User: " + session.getAttribute("username"));
        }
        // Login error
        else {
            out.println("Login Failed.");
        }
    }
}
