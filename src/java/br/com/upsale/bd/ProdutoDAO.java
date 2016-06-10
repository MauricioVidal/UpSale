package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutoDAO implements DAO<Produto> {
    
    @Override
    public List<Produto> getLista() throws Exception {
        return null;
    }
    
   
    public List<Produto> getLista(long user) throws Exception {
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "produto where id_usuario = '"+user+"'");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getLong("id"));
            p.setId_usuario(rs.getLong("id_usuario"));
            p.setId_categoria(rs.getLong("id_categoria"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getFloat("preco"));
            p.setLucro(rs.getFloat("lucro"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Produto o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "produto","nome = ?, descricao = ?, id_categoria = ?, id_usuario = ?, preco = ?, lucro = ?", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getNome());
        ps.setString(2, o.getDescricao());
        ps.setLong(3, o.getId_categoria());
        ps.setLong(4, o.getId_usuario());
        ps.setFloat(5, o.getPreco());
        ps.setFloat(6, o.getLucro());
        ps.setFloat(7, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(Produto o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "produto","nome, descricao, id_categoria, id_usuario, preco, lucro", "?, ?, ?, ?, ?, ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getNome());
        ps.setString(2, o.getDescricao());
        ps.setLong(3, o.getId_categoria());
        ps.setLong(4, o.getId_usuario());
        ps.setFloat(5, o.getPreco());
        ps.setFloat(6, o.getLucro());
        boolean rs = ps.executeUpdate()==1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Produto o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "produto", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs; 
    }

    public Produto getProduto(long id) throws Exception {
        String sql = String.format(connectionFactory.getSQLSelect(), 
                "produto WHERE id = " + id);
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Produto product = null;
        if (rs.next()) {
            product = new Produto();
            product.setId(id);
            product.setId_usuario(rs.getLong("id_usuario"));
            product.setId_categoria(rs.getLong("id_categoria"));
            product.setNome(rs.getString("nome"));
            product.setDescricao(rs.getString("descricao"));
            product.setPreco(rs.getInt("preco"));
        }
        rs.close();
        stmt.close();
        con.close();
        return product;
    }
}
