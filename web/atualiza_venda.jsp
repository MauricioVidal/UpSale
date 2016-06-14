<%-- 
    Document   : atualiza_venda
    Created on : 10/06/2016, 10:49:32
    Author     : Matheus Costa
--%>

<%@page import="br.com.upsale.bd.ItemVendaDAO"%>
<%@page import="br.com.upsale.model.ItemVenda"%>
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
        <h3>Atualizaçao de Vendas</h3>

        <%
            ItemVendaDAO dao = new ItemVendaDAO();
            ItemVenda iv = dao.getItemVenda((Long) session.getAttribute("id_venda"), (Long) session.getAttribute("id_produto"));
            if (iv != null) {
                out.print("<form action=\"./atualizacao_venda\" method=\"POST\">");

                out.print("</select><br/><br/>"
                        + "<label>Quantidade: </label><br/><br/>"
                        + "<input type=\"text\" name=\"quantidade\" value=\'" + iv.getQuantidade() + "\'/><br/><br/>"
                        + "<input type=\"submit\" value=\"Atualizar Venda\"><br/>"
                        + "</form>");
            } else {
                out.print("Venda não cadastrada.<br/>"
                        + "Por favor tente novamente");
            }
        %>

    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>

