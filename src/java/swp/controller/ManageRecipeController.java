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
import javax.servlet.http.HttpSession;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ManageRecipeController", urlPatterns = {"/ManageRecipeController"})
public class ManageRecipeController extends HttpServlet {

    private static final String SUCCESS = "LoadRecipesController";
    private static final String ERROR = "error.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        RecipeDAO dao = new RecipeDAO();
        RecipeDTO recipe = new RecipeDTO();
        HttpSession session = request.getSession();
        UserDTO admin = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            if (admin != null && admin.getRole().equalsIgnoreCase("AD")) {
                String recipeID = request.getParameter("recipeID");
                String action = request.getParameter("action");
                if ("Block".equals(action)) {
                    recipe = dao.getOne(Integer.parseInt(recipeID));
                    if (recipe != null) {
                        recipe.setStatus(false);
                        if (dao.update(recipe)) {
                            url = SUCCESS;
                        } else {
                            url = ERROR;
                        }
                    } else {
                        url = ERROR;
                    }
                } else if ("Unblock".equals(action)) {
                    recipe = dao.getOne(Integer.parseInt(recipeID));
                    if (recipe != null) {
                        recipe.setStatus(true);
                        if (dao.update(recipe)) {
                            url = SUCCESS;
                        } else {
                            url = ERROR;
                        }
                    } else {
                        url = ERROR;
                    }
                } else if (action.equals("Detail")) {
                    recipe = dao.getOne(Integer.parseInt(recipeID));
                    request.setAttribute("recipeDetail", recipe);
                    url = "manageRecipesDetails.jsp";
                } else if (action.equals("Tag")) {
                    url = "LoadCategoryOfRecipesController";
                }
            } else {
                request.setAttribute("message", "You don't have permission");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Error at ManageRecipeController");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
