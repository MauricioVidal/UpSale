<%-- 
    Document   : cadastro_produto
    Created on : 06/06/2016, 08:03:00
    Author     : Marcelo Bastos
--%>
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
        <h3>Exclusão de estoques</h3>
        <%
            ItemEstoqueDAO dao = new ItemEstoqueDAO();
            List<List<String>> lista = dao.getProdutoEstoque((Long)(session.getAttribute("id")));
            if (lista.size() != 0) {
                out.print("Selecione o estoque que deseja excluir:<br/>"
                        + "<form action=\"./exclusao_estoque\" method=\"POST\"><br/>"+
                        "<table>"
                        + "<tr>    <td></td><td>Data Estoque</td><td>Produto</td><td>Preço</td>"
                        + "<td>Quantidade Disponível</td><td>Quantidade Máxima</td><td>Percentual no estoque (%)</td></tr>");
                for (List<String> l : lista) {
                    String id = l.get(0)+"_"+l.get(1);
                    out.print("<tr>"
                            + "<td><input type=\"radio\" name=\"estoque\" value=\""+ id+"\"/></td>");
                    for(int i=2; i<l.size(); i++){
                        out.print("<td>"+ l.get(i)+"</td>");
                    }
                    out.print("</tr>");
                }
                out.print("</table><br/><br/>"
                        + "<input type=\"submit\" value=\"Excluir\"><br/>"
                        + "</form>");
            } else {
                out.print("Você ainda não possui estoques cadastrados.<br/>"
                        + "Vá na janela <a href=\"./cadastro_estoque.jsp\"> Cadastro de Estoques</a>"
                        + " para cadastrar novos estoques.");
            }
        %>



    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>
