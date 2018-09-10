package br.com.olivum.banking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.google.gson.Gson;

import br.com.olivum.banking.database.BankDatabase;
import br.com.olivum.banking.model.Bank;
import br.com.olivum.banking.protocol.RequestResponse;
import br.com.olivum.banking.protocol.ServerResponse;

@WebServlet("/servlet/bank/new")
public class BankNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

        if (request.getParameter("name") == null) {
            response.getWriter().append("Error: ");
            response.getWriter().append("Invalid parameters.");

            return;
        }

        String name = request.getParameter("name");

        System.out.println("name: " + name);

        Bank bank = new Bank();

        bank.setName(name);

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

        Gson gson = new Gson();

        String str = gson.toJson(requestResponse);

        response.getWriter().append(str);
    }
}
