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
        <h3>Cadastro de Estoques</h3>
        
                <%
                ProdutoDAO dao = new ProdutoDAO();
                List<Produto> lista = dao.getLista((Long) session.getAttribute("id"));
                if(lista.size() != 0){
                    out.print("<form action=\"./cadastro_estoque\" method=\"POST\">"
                            + "<label>Produto: </label><br/><br/>"
                            + "<select name=\"estoque\">");
                    for(Produto p: lista) {
                        out.print("<option value=\"" + p.getId() + "\">" + p.getNome() + "</option>");
                    }
                    out.print("</select><br/><br/>"
                            + "<label>Quantidade: </label><br/><br/>"
                            + "<input type=\"text\" name=\"quantidade\" /><br/><br/>"
                            + "<label>Quantidade M�xima: </label><br/><br/>"
                            + "<input type=\"text\" name=\"quantidadeMaxima\" /><br/><br/>"
                            + "<input type=\"submit\" value=\"Cadastrar Estoque\"><br/>"
                            + "</form>");
                }else{
                    out.print("Voc� ainda n�o possui produtos cadastrados.<br/>"
                            + "V� na janela <a href=\"./cadastro_produto.jsp\"> Cadastro de Produtos</a>"
                            + " para cadastrar novos produtos.");
                }
                %>
            
            
        
    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>