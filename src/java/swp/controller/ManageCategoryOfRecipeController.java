/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp.ro.CategoryOfRecipes.CategoryOfRecipesDAO;
import swp.ro.CategoryOfRecipes.CategoryOfRecipesDTO;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ManageCategoryOfRecipeController", urlPatterns = {"/ManageCategoryOfRecipeController"})
public class ManageCategoryOfRecipeController extends HttpServlet {

    private static final String SUCCESS = "LoadCategoryOfRecipesController";
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
        //categoryOfRecipe
        CategoryOfRecipesDAO corDao = new CategoryOfRecipesDAO();
        List<CategoryOfRecipesDTO> corList = new ArrayList<>();
        HttpSession session = request.getSession();
        UserDTO admin = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            if (admin != null && admin.getRole().equalsIgnoreCase("AD")) {
                String action = request.getParameter("action");
                boolean checkInsert = false;
                boolean checkDelete = false;
                //Check action
                if ("Tag".equals(action)) {
                    String[] selectedCategoryIds = request.getParameterValues("selectedCategory");
                    String[] removedCategoryIds = request.getParameterValues("removedCategory");
                    String recipeID = request.getParameter("recipeID");
                    corList = corDao.getByRecipeID(Integer.parseInt(recipeID));
                    //check type of category
                    if (selectedCategoryIds != null) {
                        for (String selectedCategoryId : selectedCategoryIds) {
                            checkInsert = corDao.insert(Integer.parseInt(selectedCategoryId), Integer.parseInt(recipeID));
                        }
                        request.setAttribute("message", "alert('Tag Category for Recipe SUCCESS')");
                    }
                    if (removedCategoryIds != null) {
                        for (String removedCategoryId : removedCategoryIds) {
                            checkDelete = corDao.delete(Integer.parseInt(removedCategoryId), Integer.parseInt(recipeID));
                        }
                        request.setAttribute("message", "alert('Remove Category for Recipe SUCCESS')");
                    }
                    //Success or error
                    if (checkInsert || checkDelete) {
                        url = SUCCESS;
                    }
                }
//            else if ("Search".equals(action)) {
//                String categoryID = request.getParameter("categoryID");
//                corList = corDao.searchByCategoryID(Integer.parseInt(categoryID));
//                if (!corList.isEmpty()) {
//                    request.removeAttribute("LIST_RECIPES");
//                    request.setAttribute("LIST_RECIPES", corList);
//                    url = "recipeSearchByCategories.jsp";
//                }
//            }
            } else {
                request.setAttribute("message", "You don't have permission");
            }
        } catch (Exception e) {
            request.setAttribute("message", "HAVE ERROR AT ManageCategoryOfRecipeController");
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
