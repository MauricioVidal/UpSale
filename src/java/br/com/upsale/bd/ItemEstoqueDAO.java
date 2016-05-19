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
        List<ItemEstoque> lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "itemEstoque");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ItemEstoque i = new ItemEstoque();
            i.setId_estoque(rs.getLong("id_estoque"));
            i.setId_produto(rs.getLong("id_produto"));
            i.setQuantidade(rs.getInt("quantidade"));
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
                "quantidade", "?", "id_estoque = ? and id_produto = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, o.getQuantidade());
        ps.setLong(2, o.getId_estoque());
        ps.setLong(3, o.getId_produto());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(ItemEstoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "itemEstoque",
                "id_estoque, id_produto, quantidade", "?,?,?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId_estoque());
        ps.setLong(2, o.getId_produto());
        ps.setInt(3, o.getQuantidade());
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

}
