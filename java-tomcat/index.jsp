<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
--%>
<html>
    <head>
        <title>WHPLUS</title>
    </head>
    <body>
        <h1>WHPLUS</h1>

        <%
        String mensagem = "Conteúdo de string<br/>";

        // Teste

        /* Teste */

        out.println(mensagem);
        %>
        <%= mensagem %>

        <table>
            <tr>
                <td>\${1 &lt; 2}: </td>
                <td>${1 < 2}</td>
            </tr>
        </table>
    </body>
</html>
<%
System.out.println("Teste 1\n");
out.println("Teste 2");
%>
