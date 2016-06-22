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
        <h3>Informação do produto</h3>

        <%
            ProdutoDAO dao = new ProdutoDAO();
            List<String> product = dao.getProdutoCategoria((Long)session.getAttribute("id"), 
                    (Long)session.getAttribute("id_produto"));
                    
            if (product != null) {
                out.print("<b>Nome: </b>" + product.get(2)
                +"<br /><b>Categoria: </b>" + product.get(3)
                +"<br /><b>Descrição: </b>" + product.get(4)
                + "<br /><b>Preco: </b>" + product.get(5)
                + "<br />");
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
