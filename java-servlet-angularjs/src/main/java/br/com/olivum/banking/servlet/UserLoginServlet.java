package br.com.olivum.banking.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import br.com.olivum.banking.database.BankDatabase;
import br.com.olivum.banking.model.User;
import br.com.olivum.banking.model.UserSession;
import br.com.olivum.banking.protocol.RequestResponse;
import br.com.olivum.banking.protocol.ServerResponse;

@WebServlet("/servlet/login")
public class UserLoginServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(UserLoginServlet.class);
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
        logger.debug("doPost()");

        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        logger.debug("Parameters: ");

        StringBuffer stringBuffer = new StringBuffer();

        String data = "";

        try {
            BufferedReader reader = request.getReader();

            while ((data = reader.readLine()) != null) {
                logger.debug("Partial data: " + data);

                stringBuffer.append(data);
            }
        }
        catch (Exception e) {
            logger.debug("Exception: " + e.toString());

            return;
        }

        String jsonStr = stringBuffer.toString();

        logger.debug("Post data: " + jsonStr);

        Gson gson = new Gson();

        User userFromLogin = null;

        try {
            userFromLogin = gson.fromJson(jsonStr, User.class);

            logger.debug("Post data: ");
            logger.debug("Bank name: " + userFromLogin.getName());
        }
        catch (JsonIOException e) {
            logger.error("Error parsing JSON request string: " + jsonStr);

            return;
        }

        RequestResponse requestResponse = new RequestResponse();

        if (userFromLogin.getName().length() == 0 || userFromLogin.getPassword().length() == 0) {
            requestResponse.setStatus(ServerResponse.Status.ERROR);
            requestResponse.setMessage("login.parameter.error");

            response.getWriter().append(gson.toJson(requestResponse));

            return;
        }

        logger.debug("login: " + userFromLogin.getName());
        logger.debug("password: " + userFromLogin.getPassword());

        @SuppressWarnings("unchecked")
        List<User> userList = BankDatabase.getSession().createQuery("from User where name=:name")
                                                       .setParameter("name", userFromLogin.getName())
                                                       .list();

        if (userList.size() > 0) {
            User user = userList.get(0);

            logger.debug("User found: " + user.getName());

            if (user.getName().equals(userFromLogin.getName()) && user.getPassword().equals(userFromLogin.getPassword())) {
                Transaction transaction = BankDatabase.getSession().beginTransaction();

                UserSession userSession = new UserSession();

                userSession.setUserId(user.getId());

                Timestamp timestamp = new Timestamp((new Date()).getTime());
                userSession.setStartDate(timestamp);

                int id = (int) BankDatabase.getSession().save(userSession);

                if (id > 0) {
                    logger.debug("User session is registered.");
                }
                else {
                    logger.error("Error on trying to register the user session.");
                }

                // Commit transaction

                transaction.commit();

                // Update user variables

                HttpSession session = request.getSession();

                session.setAttribute("username", userFromLogin.getName());

                logger.debug("Login OK");
                logger.debug("Total Active Session: " + request.getServletContext().getAttribute("activeSessions"));
                logger.debug("Current User: " + session.getAttribute("username"));

                // Set response

                requestResponse.setStatus(ServerResponse.Status.OK);
                requestResponse.setMessage("user.login");
                requestResponse.setData(userSession);
            }
            else {
                requestResponse.setStatus(ServerResponse.Status.ERROR);
                requestResponse.setMessage("login.auth.error");
            }
        }

        response.getWriter().append(gson.toJson(requestResponse));
    }
}
