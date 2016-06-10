<%-- 
    Document   : cadastro_produto
    Created on : 06/06/2016, 08:03:00
    Author     : Marcelo Bastos
--%>
<%@page import="br.com.upsale.model.ItemEstoque"%>
<%@page import="br.com.upsale.bd.ItemEstoqueDAO"%>
<%@page import="br.com.upsale.bd.ProdutoDAO"%>
<%@page import="br.com.upsale.model.Produto"%>
<%@page import="br.com.upsale.model.Categoria"%>
<%@page import="br.com.upsale.bd.CreatorDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@include file="header.jsp" %>
<div class="container">
    <div id="formulario">
        <h3>Atualizaçao de estoques</h3>

        <%
            ItemEstoqueDAO dao = new ItemEstoqueDAO();
            ItemEstoque ie = dao.getItemEstoque((Long) session.getAttribute("id_estoque"), (Long) session.getAttribute("id_produto"));
            if (ie != null) {
                out.print("<form action=\"./atualizacao_estoque\" method=\"POST\">");

                out.print("</select><br/><br/>"
                        + "<label>Quantidade: </label><br/><br/>"
                        + "<input type=\"text\" name=\"quantidade\" value=\'" + ie.getQuantidade() + "\'/><br/><br/>"
                        + "<label>Quantidade Máxima: </label><br/><br/>"
                        + "<input type=\"text\" name=\"quantidade_maxima\" value=\'" + ie.getQuantidadeMaxima() + "\'/><br/><br/>"
                        + "<input type=\"submit\" value=\"Atualizar Produto\"><br/>"
                        + "</form>");
            } else {
                out.print("Estoque não cadastrado.<br/>"
                        + "Por favor tente novamente");
            }
        %>

    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>
