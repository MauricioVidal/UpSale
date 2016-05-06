/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import br.com.upsale.bd.conexao.Connector;
import br.com.upsale.bd.conexao.ConnectionFactory;
import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public interface DAO<T> {
    List<T> getLista() throws Exception;
    boolean atualizar(T o)throws Exception;
    boolean inserir(T o)throws Exception;
    boolean remover(T o)throws Exception;
    ConnectionFactory connectionFactory = Connector.getConnectionFactory(Connector.MYSQL);
}
