package br.com.olivum.banking.servlet.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.olivum.banking.database.BankDatabase;
import br.com.olivum.banking.model.Bank;
import br.com.olivum.banking.protocol.RequestResponseList;
import br.com.olivum.banking.protocol.ServerResponse;

@WebServlet("/servlet/bank/list")
public class BankListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BankListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        @SuppressWarnings("unchecked")
        List<Bank> bankList = BankDatabase.getSession().createQuery("from Bank").list();

        List<Object> dataList = new ArrayList<>();

        if (bankList.size() > 0) {
            for (Bank bank : bankList) {
                dataList.add(bank);
            }
        }

        RequestResponseList requestResponse = new RequestResponseList();

        requestResponse.setStatus(ServerResponse.Status.OK);
        requestResponse.setMessage("ok");
        requestResponse.setData(dataList);

        Gson gson = new Gson();

        String str = gson.toJson(requestResponse);

        response.getWriter().append(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("");
    }
}
