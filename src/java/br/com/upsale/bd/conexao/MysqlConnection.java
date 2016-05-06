/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio R. Vidal
 */
public class MysqlConnection implements ConnectionFactory {

    private static final String HOST_BD = "www2.bcc.unifal-mg.edu.br";
    private static final String USER_BD = "a14046";
    private static final String BD = "a14046";
    private static final String SENHA = "a14046";
    private static final int PORT_BD = 3306;
    
   @Override
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //NOI18N
            System.out.println("Conectando em BD MYSQL..."); //NOI18N
            Connection con = DriverManager.getConnection("jdbc:mysql://"+HOST_BD+":"+ PORT_BD+"/"+BD, USER_BD, SENHA); //NOI18N
            System.out.println("Conectado com Sucesso!!"); //NOI18N
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getSQLInsert() {
        return "Insert into %s(%s) values(%s)";
    }

    @Override
    public String getSQLSelect() {
        return "Select * from %s";
    }

    @Override
    public String getSQLDelete() {
        return "Delete from %s where %s";
    }

    @Override
    public String getSQLUpdate() {
        return "Update %s set %s where %s";
    }


}
