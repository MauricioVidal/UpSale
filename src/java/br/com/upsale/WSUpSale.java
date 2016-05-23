/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale;

import br.com.upsale.bd.CreatorDAO;
import br.com.upsale.bd.DAO;
import br.com.upsale.bd.EstoqueDAO;
import br.com.upsale.bd.ItemEstoqueDAO;
import br.com.upsale.bd.ItemVendaDAO;
import br.com.upsale.bd.ProdutoDAO;
import br.com.upsale.bd.UsuarioDAO;
import br.com.upsale.model.Categoria;
import br.com.upsale.model.Estoque;
import br.com.upsale.model.ItemEstoque;
import br.com.upsale.model.ItemVenda;
import br.com.upsale.model.Produto;
import br.com.upsale.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mauricio R. Vidal
 */
@Path("upsale")
public class WSUpSale {

    @Context
    private UriInfo context;

    private static Gson GSON;

    /**
     * Creates a new instance of WSUpSale
     */
    public WSUpSale() {
        if (GSON == null) {
            GSON = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        }
    }

    /**
     * Retrieves representation of an instance of br.com.upsale.WSUpSale
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("listar/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategorias() {
        List<Categoria> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.CATEGORIA);
            lista = dao.getLista();
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
    }

    @POST
    @Path("listar/produto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getProdutos(@FormParam("id") long id_user) {
        List<Produto> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.PRODUTO);
            lista = ((ProdutoDAO) dao).getLista(id_user);
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
    }

    @GET
    @Path("listar/estoque")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEstoques() {
        List<Estoque> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.ESTOQUE);
            lista = dao.getLista();
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
    }

    @PUT
    @Path("listar/item_estoque")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getItemEstoque(@FormParam("id") long id_produto) {
        List<ItemEstoque> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.ITEMESTOQUE);
            lista = ((ItemEstoqueDAO) dao).getLista();
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
    }

    @GET
    @Path("listar/venda")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVendas() {
        List<Estoque> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.VENDA);
            lista = dao.getLista();
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
    }

    @PUT
    @Path("listar/item_venda")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getItemVendas(@FormParam("id") long id_produto) {
        
        List<ItemVenda> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.ITEMVENDA);
            lista = ((ItemVendaDAO) dao).getLista(id_produto);
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(id_produto);
        return GSON.toJson(lista);
    }

    @PUT
    @Path("/autenticacao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String autenticar(@FormParam("login") String login, @FormParam("senha") String senha) {
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.USUARIO);
            List<Usuario> lista = ((UsuarioDAO)dao).getLista(login);
            for (Usuario u : lista) {
                if(u.getSenha().equals(senha)){
                    return GSON.toJson(1);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(0);
    }

    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "";
    }
//
//    /**
//     * PUT method for updating or creating an instance of WSUpSale
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/json")
//    public String putJson(String content) {
//        return content;
//    }
}
