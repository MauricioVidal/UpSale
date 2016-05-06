/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd.conexao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a14020
 */
public class Connector {
    
    public static final Class MYSQL = MysqlConnection.class;

    private Connector() {
    }
    
    public static ConnectionFactory getConnectionFactory(Class c){
        try {
            return (ConnectionFactory) c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
