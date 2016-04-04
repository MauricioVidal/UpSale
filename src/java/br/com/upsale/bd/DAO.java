/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public interface DAO<T> {
    List<T> getLista();
    boolean atualizar(T o);
    boolean inserir(T o);
    boolean remover(T o);
}
