<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>home.jsp</title>
  </head>
  <body>
    <!-- Page title -->
    <%! String title = "home.jsp"; %>

    <h1><%= title %></h1>

    <!-- Go back to home -->
    <a href="index.html">Go to index.html</a>

    <br/><br/>

    <!-- Some environment information -->
    Page context path: ${pageContext.request.contextPath}
    <br/>
    Requester IP address: <% out.println(request.getRemoteAddr()); %>


  </body>
</html>
