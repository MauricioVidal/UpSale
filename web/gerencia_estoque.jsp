<%-- 
    Document   : cadastro_produto
    Created on : 06/06/2016, 08:03:00
    Author     : Marcelo Bastos
--%>
<%@page import="br.com.upsale.bd.ProdutoDAO"%>
<%@page import="br.com.upsale.model.Produto"%>
<%@page import="br.com.upsale.model.Categoria"%>
<%@page import="br.com.upsale.bd.CreatorDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@include file="header.jsp" %>
<div class="container">
        <h3>Ger�ncia de Estoques</h3><br />
        Clique na op��o desejada:<br />
        <a class="item" href="./cadastro_estoque.jsp">Cadastro de Estoques </a><br />
        <a class="item" href="./atualizacao_estoque.jsp">Atualiza��o de Estoques </a><br />
        <a class="item" href="./exclusao_estoque.jsp">Exclus�o de Estoques </a><br />
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>