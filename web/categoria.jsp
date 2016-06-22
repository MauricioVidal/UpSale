<%@page import="java.util.List"%>
<%@page import="br.com.upsale.bd.CategoriaDAO"%>
<div id="categoria" class="categoria">
    <div class="modal-content">
        <span onclick="document.getElementById('categoria').style.display = 'none'" 
              class="closebtn">&times;</span>
        <br />
        <h2 class="titulo">Categorias</h2>
        <p>
        Percentual de produtos cadastrados <br />do usuário <% out.print((String) session.getAttribute("nome")); %> por categoria:
        </p>
        <p>
        <Table>
            <tr><td>Categoria</td><td>Percentual (%)</td></tr>
            <%
                    CategoriaDAO categoriaDao = new CategoriaDAO();
                    List<List<String>> listaC = categoriaDao.getProdutoEstoque((Long) session.getAttribute("id"));
                    for (List<String> l : listaC) {
                        out.print("<tr><td>" + l.get(0)
                                + "</td><td>" + l.get(1)
                                + "</td></tr>");
                    }
            %>
        </Table>
        </p>
        <br />
    </div>
</div>