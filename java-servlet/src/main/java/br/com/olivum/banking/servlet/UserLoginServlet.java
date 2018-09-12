package br.com.olivum.banking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.com.olivum.banking.database.BankDatabase;
import br.com.olivum.banking.protocol.RequestResponse;
import br.com.olivum.banking.protocol.ServerResponse;

@WebServlet("/servlet/login")
public class UserLoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserLoginServlet.class);
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
        response.setContentType("application/json");

        if (request.getParameter("username") == null || request.getParameter("password") == null) {
            RequestResponse requestResponse = new RequestResponse();

            requestResponse.setStatus(ServerResponse.Status.ERROR);
            requestResponse.setMessage("login.parameter.error");

            Gson gson = new Gson();

            response.getWriter().append(gson.toJson(requestResponse));

            return;
        }

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        logger.debug("login: " + userName);
        logger.debug("password: " + password);

        // Login success
        if (!userName.isEmpty() && !password.isEmpty()) {
            HttpSession session = request.getSession();

            session.setAttribute("username", userName);

            logger.debug("<h3>Login Success</h3>");
            logger.debug("Total Active Session: " + request.getServletContext().getAttribute("activeSessions"));
            logger.debug("<br/>Current User: " + session.getAttribute("username"));

            RequestResponse requestResponse = new RequestResponse();

            requestResponse.setStatus(ServerResponse.Status.OK);
            requestResponse.setMessage("login");

            Gson gson = new Gson();

            response.getWriter().append(gson.toJson(requestResponse));
        }
        // Login error
        else {
            logger.error("Login Failed. Parameter empty.");

            RequestResponse requestResponse = new RequestResponse();

            requestResponse.setStatus(ServerResponse.Status.ERROR);
            requestResponse.setMessage("login.parameter.empty");

            Gson gson = new Gson();

            response.getWriter().append(gson.toJson(requestResponse));
        }
    }
}
