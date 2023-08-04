/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.User.UserDTO;
import swp.ro.feedback.FeedBackDAO;
import swp.ro.feedback.FeedBackDTO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "FeedBackController", urlPatterns = {"/FeedBackController"})
public class FeedBackController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
        int recipeID = Integer.parseInt(request.getParameter("recipeID"));

        try {
            if (user == null) {
                request.setAttribute("failed", "Plz login to feedback");
                request.getRequestDispatcher("/MainController?action=RecipeDetail&recipeID=" + recipeID).forward(request, response);
            } else {
                String content = request.getParameter("content");
                String userName = request.getParameter("userName");
                int userID = user.getUserID();
                FeedBackDAO fDAO = new FeedBackDAO();
                FeedBackDTO feedback = new FeedBackDTO();
                Date datePost = new Date();
                feedback.setContent(content);
                feedback.setFeedbackDate(datePost);
                feedback.setUserID(userID);
                feedback.setRecipeID(recipeID);
                feedback.setUserName(userName);
                fDAO.addComments(feedback);
                  response.sendRedirect(request.getContextPath() + "/MainController?action=RecipeDetail&recipeID=" + recipeID);
            }
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/MainController?action=RecipeDetail&recipeID=" + recipeID).forward(request, response);

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
