<%-- 
    Document   : cadastro_usuario
    Created on : 02/06/2016, 13:54:00
    Author     : Mauricio R. Vidal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpSale</title>
    </head>
    <body>
        <div id="conteudo">
            <div id="cabecalho">
                <%@include file="header.jsp" %>
            </div>
            <div class="container">
                <div id="formulario">
                    <h3>Cadastro</h3>
                    <form action="./cadastro_login" method="POST">
                        <label>Nome: </label><br/><br/>
                        <input type="text" name="nome" /><br/><br/>
                        <label>Nome de Usuario: </label><br/><br/>
                        <input type="text" name="login" /><br/><br/>
                        <label>Senha: </label><br/><br/>
                        <input type="password" name="senha" /><br/><br/>
                        <input type="submit" value="Cadastrar-se"><br/>
                    </form>
                </div>
            </div>

        </div>

    </body>
</html>