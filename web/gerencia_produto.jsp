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
        <h3>Gerência de Produtos</h3><br />
        Selecione a opção desejada:<br />
        <a class="item" href="./cadastro_produto.jsp">Cadastro de Produtos </a><br />
        <a class="item" href="./atualizacao_produto_selecao.jsp">Atualização de Produtos </a><br />
        <a class="item" href="./exclusao_produto.jsp">Exclusão de Produtos </a><br />
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>