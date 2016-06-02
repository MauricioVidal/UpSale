/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import br.com.upsale.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public class UsuarioDAO implements DAO<Usuario>{
    
    @Override
    public List<Usuario> getLista() throws Exception{
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "usuario");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            lista.add(u);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
    
    public List<Usuario> getLista(String login) throws Exception{
        List lista = new ArrayList();
        String sql = String.format(connectionFactory.getSQLSelect(), "usuario where login = '"+login+"'");
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            lista.add(u);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    @Override
    public boolean atualizar(Usuario o) throws Exception{
        String sql = String.format(connectionFactory.getSQLUpdate(), "usuario",
                "login, nome, senha", "?,?,?", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getLogin());
        ps.setString(2, o.getNome());
        ps.setString(3, o.getSenha());
        ps.setLong(4, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean inserir(Usuario o) throws Exception{
        String sql = String.format(connectionFactory.getSQLInsert(), "usuario", 
                "login, nome, senha", "?,?,?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, o.getLogin());
        ps.setString(2, o.getNome());
        ps.setString(3, o.getSenha());
        boolean rs = ps.executeUpdate()==1;
        ps.close();
        con.close();
        return rs;
    }

    @Override
    public boolean remover(Usuario o) throws Exception{
        String sql = String.format(connectionFactory.getSQLDelete(), "usuario", "id = ?");
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, o.getId());
        boolean rs = ps.executeUpdate() == 1;
        ps.close();
        con.close();
        return rs;
    }
    
    public Usuario autenticar(String login, String senha) throws SQLException{
        String sql = String.format(connectionFactory.getSQLSelect(), String.format("usuario where login = '%s' and senha = '%s'",login, senha));
        Connection con = connectionFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Usuario u = null;
        while(rs.next()){
            u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            break;
        }
        rs.close();
        stmt.close();
        con.close();
        return u;
    }
    
}
