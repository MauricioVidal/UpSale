/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.servlets;

import br.com.upsale.bd.CreatorDAO;
import br.com.upsale.bd.DAO;
import br.com.upsale.model.ItemEstoque;
import br.com.upsale.model.ItemVenda;
import br.com.upsale.model.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matheus Costa
 */
@WebServlet(name = "ServletAtualizacaoVenda", urlPatterns = {"/atualizacao_venda"})
public class ServletAtualizacaoVenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            DAO<ItemVenda> dao = CreatorDAO.create(CreatorDAO.ITEMVENDA);
            HttpSession session = request.getSession();
            ItemVenda iv = new ItemVenda();
            iv.setId_venda((Long)session.getAttribute("id_venda"));
            iv.setId_produto((Long)session.getAttribute("id_produto"));
            iv.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            
            session.removeAttribute("id_produto");
            session.removeAttribute("id_venda");
           
            dao.atualizar(iv);
            
            response.sendRedirect("./selecao_atualizacao_venda.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ServletAtualizacaoVenda.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("./?error-cadastro");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
