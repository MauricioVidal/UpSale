/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauricio R. Vidal
 */
public abstract class CreatorDAO {
    public static final Class<CategoriaDAO> CATEGORIA = CategoriaDAO.class;
    public static final Class<EstoqueDAO> ESTOQUE = EstoqueDAO.class;
    public static final Class<ItemVendaDAO> ITEMVENDA = ItemVendaDAO.class;
    public static final Class<ItemEstoqueDAO> ITEMESTOQUE = ItemEstoqueDAO.class;
    public static final Class<ProdutoDAO> PRODUTO = ProdutoDAO.class;
    public static final Class<UsuarioDAO> USUARIO = UsuarioDAO.class;
    private static Map<Class, DAO> map = new HashMap();
    private CreatorDAO() {
    }
    public static DAO create(Class<? extends DAO> c) throws Exception{
        if(!map.containsKey(c)){
            map.put(c, c.newInstance());
        }
        return map.get(c);
    }
    
    
}
