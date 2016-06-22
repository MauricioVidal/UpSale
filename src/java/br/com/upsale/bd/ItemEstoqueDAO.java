/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.ItemEstoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public class ItemEstoqueDAO implements DAO<ItemEstoque> {

    @Override
    public List<ItemEstoque> getLista() throws Exception {
        return null;
    }
    public List<ItemEstoque> getLista(long id_produto) throws Exception {
        List<ItemEstoque> lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "itemEstoque where id_produto = '"+ id_produto+"'");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ItemEstoque i = new ItemEstoque();
            i.setId_estoque(rs.getLong("id_estoque"));
            i.setId_produto(rs.getLong("id_produto"));
            i.setQuantidade(rs.getInt("quantidade"));
            i.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));
            lista.add(i);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(ItemEstoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "itemEstoque",
                "quantidade = ?, quantidade_maxima = ?", "id_estoque = ? and id_produto = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, o.getQuantidade());
        ps.setInt(2, o.getQuantidadeMaxima());
        ps.setLong(3, o.getId_estoque());
        ps.setLong(4, o.getId_produto());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(ItemEstoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "itemEstoque",
                "id_estoque, id_produto, quantidade, quantidade_maxima", "?,?,?,?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId_estoque());
        ps.setLong(2, o.getId_produto());
        ps.setInt(3, o.getQuantidade());
        ps.setInt(4, o.getQuantidadeMaxima());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(ItemEstoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "itemEstoque", "id_estoque = ? and id_produto = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId_estoque());
        ps.setLong(2, o.getId_produto());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    public List<List<String>> getProdutoEstoque(long id_usuario) throws Exception{
        List<List<String>> lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "produto_estoque pe where pe.id_usuario = " + id_usuario);
        Connection con = connectionFactory.getConnection();
        Connection con2 = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        Statement stmt2 = con2.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String sql2 = new String();
        while (rs.next()) {  
            sql2 = "select porcentagem_item_estoque("+ rs.getString("id_produto") + ", " + id_usuario + ")" + " as percentual";
            ResultSet rs2 = stmt2.executeQuery(sql2);
            List<String> l = new ArrayList<>();
            l.add(rs.getString("id_produto"));
            l.add(rs.getString("id_estoque"));
            //l.add(rs.getString("data_estoque"));
            String date = rs.getString("data_estoque").substring(0, 7);
            String [] aux = date.split("-");
            l.add(aux[1]+"/"+aux[0]);
            l.add(rs.getString("nome_produto"));
            l.add(rs.getString("preco"));
            //l.add(rs.getString("quantidade"));
            //l.add(rs.getString("quantidade_maxima"));
            rs2.next();
            l.add(rs2.getString("percentual"));            
            lista.add(l);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
    
     public ItemEstoque getItemEstoque(long id_estoque, long id_produto) throws Exception {
        String sql = String.format(connectionFactory.getSQLSelect(), 
                "itemEstoque WHERE id_estoque = " + id_estoque + " and id_produto = "+id_produto);
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ItemEstoque ie = null;
        if (rs.next()) {
            ie = new ItemEstoque();
            ie.setId_estoque(id_estoque);
            ie.setId_produto(id_produto);
            ie.setQuantidade(rs.getInt("quantidade"));
            ie.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));
        }
        rs.close();
        stmt.close();
        con.close();
        return ie;
    }
}
