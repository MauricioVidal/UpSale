<%-- 
    Document   : selecao_atualizacao_venda
    Created on : 10/06/2016, 16:31:25
    Author     : Matheus Costa
--%>

<%@page import="br.com.upsale.bd.ItemVendaDAO"%>
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
            List<List<String>> lista = dao.getProdutoVenda((Long) session.getAttribute("id"));
            if (lista.size() != 0) {
                out.print("Selecione a venda que deseja atualizar:<br/>"
                        + "<form action=\"./selecao_atualizacao_venda\" method=\"POST\"><br/>"+
                        "<table>"
                        + "<tr>    <td></td><td>Produto</td><td>Quantidade</td>"
                        + "<td>Data</td><td>Preço</td></tr>");
                for (List<String> l : lista) {
                    String id = l.get(4)+"_"+l.get(5);
                    out.print("<tr> <td><input type=\"radio\" name=\"venda\" value=\""+ id+"\"/></td>");
                    for(int i=0; i<4; i++){
                        out.print("<td>"+ l.get(i)+"</td>");
                    }
                    out.print("</tr>");
                }
                out.print("</table><br/><br/>"
                        + "<input type=\"submit\" value=\"Confirmar\"><br/>"
                        + "</form>");
            } else {
                out.print("Você ainda não possui vendas cadastradas.<br/>"
                        + "Vá na janela <a href=\"./cadastro_venda.jsp\"> Cadastro de Vendas</a>"
                        + " para cadastrar novas vendas.");
            }
        %>
    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>

