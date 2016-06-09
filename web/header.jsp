<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean sessao_ativa = session.getAttribute("login") != null;
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./style/tema.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpSale</title>
    </head>
    <body>
        <div id="conteudo">
            <div id="cabecalho">
                <img src="images/topo.jpg"/>
                <div id="menu" >
                    <div id="item_menu" class="menu">
                        <% if (sessao_ativa) {%>
                        <div class="item_menu" > <a class="item" href="./gerencia_produto.jsp"> Produtos </a></div>
                        <div class="item_menu" > <a class="item" href="./cadastro_estoque.jsp">Estoques </a></div>
                        <div class="item_menu" > <a class="item">Vendas </a></div>
                        <% }%>
                    </div>
                    <div id="button_menu" class="menu">
                        <% if (!sessao_ativa) {%>
                        <div style="width: 75%" class = "inline"></div>
                        <div class="inline">
                            <button onclick="document.getElementById('modal').style.display = 'block'" 
                                    class="item_button">Logar</button>
                            <% } else {%>
                            <div style="width: 45%" class = "inline"></div>
                            <div class="inline"> Bem vindo <% out.print(session.getAttribute("nome") + "!"); %></div>
                            <div class="inline">
                                <a href="./logoff"><button class="item_button" >Logoff</button></a>
                                <%}%>
                            </div>
                        </div>
                    </div>

                    <div id="modal" class="modal">
                        <div class="modal-content">
                            <span onclick="document.getElementById('modal').style.display = 'none'" 
                                  class="closebtn">&times;</span>
                            <div id="formulario">
                                <h2 class="titulo">Login</h2><br/>
                                <form action="./logar" method="POST">
                                    <label>Nome de Usuario: </label><br/><br/>
                                    <input type="text" name="login" /><br/><br/>
                                    <label>Senha: </label><br/><br/>
                                    <input type="password" name="senha" /><br/><br/>
                                    <a href="./cadastro_usuario.jsp"> Cadastrar-se</a><br/><br/>
                                    <input type="submit" value="Logar"><br/>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>