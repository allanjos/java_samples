<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>home.jsp</title>
  </head>
  <body>
    JSP test
    <br/>
    <% out.println("Your IP address is " + request.getRemoteAddr()); %>
    <br/>
    <ul>
        <li>
            <a href="./">Home page</a>
        </li>
    </ul>
  </body>
</html>
