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
<%@include file="categoria.jsp" %>

<div class="container">
    <div id="formulario">
        <h3>Cadastro de Produtos</h3>
        <label>Categoria: </label>
        <button onclick="document.getElementById('categoria').style.display = 'block'" 
                class="categoria_button">Mais sobre suas categorias</button>
        <br/><br/>

        <form action="./cadastro_produto" method="POST">

            <select name="categoria">
                <%
                    DAO<Categoria> dao = CreatorDAO.create(CreatorDAO.CATEGORIA);
                    List<Categoria> lista = dao.getLista();
                    for (Categoria c : lista) {
                        out.print("<option value=\"" + c.getId() + "\">" + c.getNome() + "</option>");
                    }
                %>
            </select><br/><br/>
            <label>Nome: </label><br/><br/>
            <input type="text" name="nome" /><br/><br/>
            <label>Descri��o: </label><br/><br/>
            <input type="text" name="descricao" /><br/><br/>
            <label>Pre�o: </label><br/><br/>
            <input type="text" name="preco" /><br/><br/>
            <input type="submit" value="Cadastrar Produto"><br/>
        </form>
    </div>
</div>

<!-- TAG Conteudo-->
</div>
</body>
</html>