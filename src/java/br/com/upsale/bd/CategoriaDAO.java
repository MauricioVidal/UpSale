/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import static br.com.upsale.bd.DAO.connectionFactory;
import br.com.upsale.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a14020
 */
public class CategoriaDAO implements DAO<Categoria> {

    @Override
    public List<Categoria> getLista() throws Exception {
        List<Categoria> lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "categoria");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Categoria c = new Categoria();
            c.setId(rs.getLong("id"));
            c.setNome(rs.getString("nome"));
            lista.add(c);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Categoria o) throws Exception {
        String sql = String.format(connectionFactory.getSQLUpdate(), "categoria",
                "nome", "?", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getNome());
        ps.setLong(2, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(Categoria o) throws Exception {
        String sql = String.format(connectionFactory.getSQLInsert(), "categoria", 
                "nome", "?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getNome());
        boolean rs = ps.executeUpdate()==1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Categoria o) throws Exception {
        String sql = String.format(connectionFactory.getSQLDelete(), "categoria", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    
    }

}
