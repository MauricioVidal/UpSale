/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.bd;

import br.com.upsale.model.Usuario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio R. Vidal
 */
public class UsuarioDAO implements DAO<Usuario>{

    @Override
    public List<Usuario> getLista() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "Select * from usuario";
        //
        return null;
    }

    @Override
    public boolean atualizar(Usuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Usuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Usuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
