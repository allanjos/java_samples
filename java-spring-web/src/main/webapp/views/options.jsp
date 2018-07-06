<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>

    <script type="text/javascript">
      function redir() {
        var nomeInformado = prompt("Favor informar um nome: ", "");

        window.location.href = "investments-menu.jsp?option=" + nomeInformado;
      }
    </script>

  </head>
  <body>
    <div align="center">
      <h2>y.jsp</h2>
      <h3>
        <a href="#" onclick="redir();">Redirect</a>
      </h3>
    </div>
  </body>
</html>