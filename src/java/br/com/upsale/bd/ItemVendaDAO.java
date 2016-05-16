/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.ItemEstoque;
import br.com.upsale.model.ItemVenda;
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
public class ItemVendaDAO implements DAO<ItemVenda> {

    @Override
    public List<ItemVenda> getLista() throws Exception {
        List<ItemVenda> lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "itemEstoque");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ItemVenda i = new ItemVenda();
            i.setId_produto(rs.getLong("id_produto"));
            i.setId_venda(rs.getLong("id_venda"));
            i.setQuantidade(rs.getInt("quantidade"));
            lista.add(i);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(ItemVenda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "itemVenda",
                "quantidade", "?", "id_produto = ? and id_venda = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, o.getQuantidade());
        ps.setLong(2, o.getId_produto());
        ps.setLong(3, o.getId_venda());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(ItemVenda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "itemEstoque",
                "id_produto, id_venda, quantidade", "?,?,?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId_produto());
        ps.setLong(2, o.getId_venda());
        ps.setInt(3, o.getQuantidade());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(ItemVenda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "usuario", "id_produto = ? and id_venda = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId_produto());
        ps.setLong(2, o.getId_venda());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

}
