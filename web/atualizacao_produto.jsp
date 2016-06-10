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
    <div id="formulario">
        <h3>Atualizaçao de produtos</h3>

        <%
            ProdutoDAO dao = new ProdutoDAO();
            Produto product = dao.getProduto((Long) session.getAttribute("id_produto"));
            if (product != null) {
                DAO<Categoria> dao2 = CreatorDAO.create(CreatorDAO.CATEGORIA);
                List<Categoria> lista2 = dao2.getLista();
                out.print("<form action=\"./atualizacao_produto\" method=\"POST\">"
                        + "<label>Categoria: </label><br/><br/>"
                        + "<select name=\"categoria\">");
                for (Categoria c : lista2) {
                    String s = "";
                    Long t = c.getId();
                    if (c.getId() == product.getId_categoria()) {
                        s = " selected";
                    }
                    out.print("<option value=\"" + c.getId() + "\"" + s
                            +">" + c.getNome() + "</option>");
                }

                out.print("</select><br/><br/>"
                        + "<label>Nome: </label><br/><br/>"
                        + "<input type=\"text\" name=\"nome\" value=\'" + product.getNome() + "\'/><br/><br/>"
                        + "<label>Descrição: </label><br/><br/>"
                        + "<input type=\"text\" name=\"descricao\" value=\'" + product.getDescricao() + "\'/><br/><br/>"
                        + "<label>Preço: </label><br/><br/>"
                        + "<input type=\"text\" name=\"preco\" value=\'" + product.getPreco() + "\'/><br/><br/>"
                        + "<input type=\"submit\" value=\"Atualizar Produto\"><br/>"
                        + "</form>");
            } else {
                out.print("Produto não cadastrado.<br/>"
                        + "Por favor tente novamente");
            }
        %>

    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>
