<%-- 
    Document   : cadastro_produto
    Created on : 06/06/2016, 08:03:00
    Author     : Marcelo Bastos
--%>
<%@page import="br.com.upsale.model.Categoria"%>
<%@page import="br.com.upsale.bd.CreatorDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@page import="br.com.upsale.bd.DAO"%>
<%@include file="header.jsp" %>
<div class="container">
    <div id="formulario">
        <h3>Cadastro de Produtos</h3>
        <form action="./cadastro_produto" method="POST">
            <label>Categoria: </label><br/><br/>
            <select name="categoria">
                <% DAO<Categoria> dao = CreatorDAO.create(CreatorDAO.CATEGORIA);
                    List<Categoria> lista = dao.getLista();
                    for(Categoria c: lista) {
                        out.print("<option value=\"" + c.getId() + "\">" + c.getNome() + "</option>");
                    }
//                    <option value=c.getNome()>>Botafogo</option>
//                    <option value="fla">Flamengo</option>
//                    <option value="flu">Fluminense</option>
//                    <option value="vasco">Vasco da Gama</option>
                %>
            </select><br/><br/>
            <label>Nome: </label><br/><br/>
            <input type="text" name="nome" /><br/><br/>
            <label>Descrição: </label><br/><br/>
            <input type="text" name="descricao" /><br/><br/>
            <label>Preço: </label><br/><br/>
            <input type="text" name="preco" /><br/><br/>
            <input type="submit" value="Cadastrar Produto"><br/>
        </form>
    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>