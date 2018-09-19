package br.com.olivum.banking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.olivum.banking.protocol.ServerResponse;

import br.com.olivum.banking.protocol.RequestResponse;

@WebServlet("/servlet/logout")
public class UserLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logout(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logout(request, response);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        session.invalidate();

        PrintWriter out = response.getWriter();

        out.println("Successfully logged out.");

        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setStatus(ServerResponse.Status.OK);
        requestResponse.setMessage("user.logout");

        Gson gson = new Gson();

        response.getWriter().append(gson.toJson(requestResponse));
    }
}