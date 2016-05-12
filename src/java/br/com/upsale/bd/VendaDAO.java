/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.Estoque;
import br.com.upsale.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public class VendaDAO implements DAO<Venda>{
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Venda> getLista() throws Exception {
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "venda");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Venda v = new Venda();
            v.setId(rs.getLong("id"));
            v.setData(rs.getDate("data"));
            lista.add(v);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Venda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "venda","data", "?", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(o.getData()));
        ps.setLong(2, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(Venda o) throws Exception {
         String sql = String.format(connectionFactory.getSQLInsert(), "venda",
                "data", "?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(o.getData()));
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Venda o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "venda", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }
    
}
