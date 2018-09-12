package br.com.olivum.banking.servlet.bank;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import br.com.olivum.banking.database.BankDatabase;
import br.com.olivum.banking.model.Bank;
import br.com.olivum.banking.protocol.RequestResponse;
import br.com.olivum.banking.protocol.ServerResponse;

@WebServlet("/servlet/bank/new")
public class BankNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(BankNewServlet.class);

    public BankNewServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        Bank bank = null;

        try {
            bank = gson.fromJson(jsonStr, Bank.class);

            logger.debug("Post data: ");
            logger.debug("Bank name: " + bank.getName());
        }
        catch (JsonIOException e) {
            logger.error("Error parsing JSON request string: " + jsonStr);

            return;
        }

        Transaction transaction = BankDatabase.getSession().beginTransaction();

        RequestResponse requestResponse = new RequestResponse();

        int id = (int) BankDatabase.getSession().save(bank);

        if (id > 0) {
            requestResponse.setStatus(ServerResponse.Status.OK);
            requestResponse.setMessage("ok");
        }
        else {
            requestResponse.setStatus(ServerResponse.Status.OK);
            requestResponse.setMessage("bank.new.error");
        }

        // Commit transaction

        transaction.commit();

        gson = new Gson();

        response.getWriter().append(gson.toJson(requestResponse));
    }
}
