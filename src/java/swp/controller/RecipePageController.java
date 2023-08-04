/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.Category.CategoryDAO;
import swp.ro.Category.CategoryDTO;
import swp.ro.CategoryOfRecipes.CategoryOfRecipesDAO;
import swp.ro.CategoryOfRecipes.CategoryOfRecipesDTO;
import swp.ro.FavoriteRecipes.FavoriteRecipesDAO;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;
import swp.ro.rating.RatingDAO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "RecipePageController", urlPatterns = {"/RecipePageController"})
public class RecipePageController extends HttpServlet {

    private static final String SUCCESS = "recipePage.jsp";
    private static final String ERROR = "error.jsp";
    private static final String TEST = "test.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            //Create model
            RecipeDAO daoRecipe = new RecipeDAO();
            UserDAO daoUser = new UserDAO();
            FavoriteRecipesDAO daoFavority = new FavoriteRecipesDAO();
            RatingDAO ratingDAO = new RatingDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            CategoryOfRecipesDAO categoryOfRecipesDAO = new CategoryOfRecipesDAO();
            //Call List
            List<RecipeDTO> listRecipe = daoRecipe.getListSearchRecipe("");
            List<UserDTO> listUser = daoUser.getListSearchUser("");
            List<CategoryDTO> listCategory = categoryDAO.getListCategories();
            List<CategoryOfRecipesDTO> listCoR = categoryOfRecipesDAO.getAll();
            Map<Integer, Double> rating = ratingDAO.getAllRatingRecipe();
            request.setAttribute("SEARCH_LIST_RECIPE", listRecipe);
            request.setAttribute("SEARCH_LIST_USER", listUser);
            request.setAttribute("SEARCH_LIST_RATING", rating);
            request.setAttribute("LIST_CATEGORY", listCategory);
            request.setAttribute("LIST_COR", listCoR);
            url = SUCCESS;
        } catch (Exception e) {
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
