/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale;

import br.com.upsale.bd.CreatorDAO;
import br.com.upsale.bd.DAO;
import br.com.upsale.model.Categoria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
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
        if(GSON == null){
            GSON = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        }
    }

    /**
     * Retrieves representation of an instance of br.com.upsale.WSUpSale
     * @return an instance of java.lang.String
     */
    
    @GET
    @Path("listar/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategorias(){
        List<Categoria> lista = new LinkedList();
        try {
            DAO dao = CreatorDAO.create(CreatorDAO.CATEGORIA);
            lista = dao.getLista();
        } catch (Exception ex) {
            Logger.getLogger(WSUpSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GSON.toJson(lista);
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
