package br.com.olivum.springweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/investments")
public class InvestmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) {
        System.out.println("InvestmentsServlet.init()");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       response.setContentType("text/html;charset=UTF-8");

       PrintWriter out = response.getWriter();

       try {
          out.println("<!DOCTYPE html>");
          out.println("<html><head>");
          out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
          out.println("<title>Hello, World</title></head>");
          out.println("<body>");
          out.println("<h1>InvestmentsServlet</h1>");

          out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
          out.println("<p>Protocol: " + request.getProtocol() + "</p>");
          out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
          out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

          out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
          out.println("</body>");
          out.println("</html>");
       }
       finally {
          out.close();  // Always close the output writer
       }
    }
}