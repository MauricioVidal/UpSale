/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd.conexao;

import java.sql.Connection;

/**
 *
 * @author Mauricio R. Vidal
 */
public interface ConnectionFactory {
    
    Connection getConnection();
    String getSQLInsert();
    String getSQLSelect();
    String getSQLDelete();
    String getSQLUpdate();
}
