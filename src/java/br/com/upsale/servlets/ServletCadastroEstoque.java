/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.servlets;

import br.com.upsale.bd.CreatorDAO;
import br.com.upsale.bd.DAO;
import br.com.upsale.bd.EstoqueDAO;
import br.com.upsale.model.Estoque;
import br.com.upsale.model.ItemEstoque;
import java.io.IOException;
import java.util.Date;
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
 * @author Marcelo Bastos
 */
@WebServlet(name = "ServletCadastroEstoque", urlPatterns = {"/cadastro_estoque"})
public class ServletCadastroEstoque extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("redirect", "./cadastro_estoque.jsp");
        try {
            DAO<ItemEstoque> dao = CreatorDAO.create(CreatorDAO.ITEMESTOQUE);
            EstoqueDAO estoque = new EstoqueDAO();
            Estoque e = new Estoque();
            e.setData(new Date());
            estoque.inserir(e);
            ItemEstoque item = new ItemEstoque();
            item.setId_produto(Long.parseLong(request.getParameter("estoque")));
            Long t = estoque.getDateId(e.getData());
            item.setId_estoque(estoque.getDateId(e.getData()));
            item.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            item.setQuantidadeMaxima(Integer.parseInt(request.getParameter("quantidadeMaxima")));

            dao.inserir(item);
            session.setAttribute("msg", "Estoque cadastrado com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(ServletCadastroEstoque.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("msg", "Erro ao cadastrar estoque. Por favor tente novamente.");
        }
        response.sendRedirect("./checagem.jsp");
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
