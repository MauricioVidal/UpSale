/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.Estoque;
import br.com.upsale.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a14020
 */
public class EstoqueDAO implements DAO<Estoque> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Estoque> getLista() throws Exception {
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "estoque");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Estoque e = new Estoque();
            e.setId(rs.getLong("id"));
            e.setData(rs.getDate("data_estoque"));
            lista.add(e);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Estoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "estoque",
                "data_estoque", "?", "id = ?");
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
    public boolean inserir(Estoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "estoque",
                "data_estoque", "?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sdf.format(o.getData()));
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Estoque o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "estoque", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

}
