<%-- 
    Document   : cadastro_produto
    Created on : 06/06/2016, 08:03:00
    Author     : Marcelo Bastos
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
        <h3>Exclusão de Venda</h3>
        <%
            ItemVendaDAO dao = new ItemVendaDAO();
            List<List<String>> lista = dao.getProdutoVenda();
            if (lista.size() != 0) {
                out.print("Selecione a venda que deseja excluir:<br/>"
                        + "<form action=\"./exclusao_venda\" method=\"POST\"><br/>"+
                        "<table>"
                        + "<tr>    <td></td><td>Produto</td><td>Quantidade</td>"
                        + "<td>Data</td></tr>");
                for (List<String> l : lista) {
                    String id = l.get(3)+"_"+l.get(4);
                    out.print("<tr> <td><input type=\"radio\" name=\"venda\" value=\""+ id+"\"/></td>");
                    for(int i=0; i<l.size(); i++){
                        out.print("<td>"+ l.get(i)+"</td>");
                    }
                    out.print("</tr>");
                }
                out.print("</table><br/><br/>"
                        + "<input type=\"submit\" value=\"Excluir\"><br/>"
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
