/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upsale.servlets;

import br.com.upsale.bd.CreatorDAO;
import br.com.upsale.bd.DAO;
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
 * @author Marcelo Bastos
 */
@WebServlet(name = "ServletCadastroProduto", urlPatterns = {"/cadastro_produto"})
public class ServletCadastroProduto extends HttpServlet {

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
        session.setAttribute("redirect", "./cadastro_produto.jsp");
        try {
            DAO<Produto> dao = CreatorDAO.create(CreatorDAO.PRODUTO);
            Produto product = new Produto();
            
            product.setId_usuario((Long) session.getAttribute("id"));
            product.setId_categoria(Long.parseLong(request.getParameter("categoria")));
            product.setNome(request.getParameter("nome"));
            product.setDescricao(request.getParameter("descricao"));
            product.setPreco(Float.parseFloat(request.getParameter("preco")));
            
            dao.inserir(product);
            session.setAttribute("msg", "Produto cadastrado com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(ServletCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("msg", "Erro ao cadastrar produto. Por favor tente novamente.");
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
