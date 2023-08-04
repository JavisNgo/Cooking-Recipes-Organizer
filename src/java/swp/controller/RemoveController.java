/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.User.UserDTO;
import swp.ro.savedRecipes.SavedRecipesDAO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "RemoveController", urlPatterns = {"/RemoveController"})
public class RemoveController extends HttpServlet {

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
        String op = request.getParameter("op");
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        switch (op) {
            case "Remove": {
                try {
                    int userID = user.getUserID();
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    SavedRecipesDAO dao = new SavedRecipesDAO();
                    dao.removeSavedRecipe(userID, recipeID);
                    response.sendRedirect(request.getContextPath() + "/save_favorite/saved.do?userID=" + user.getUserID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
            case "remove": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    SavedRecipesDAO dao = new SavedRecipesDAO();
                    dao.removeSavedRecipe(userID, recipeID);
                    response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
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
