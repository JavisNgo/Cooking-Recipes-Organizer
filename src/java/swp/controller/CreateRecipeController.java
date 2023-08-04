/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp.ro.Nutritional.NutritionalDAO;
import swp.ro.Nutritional.NutritionalDTO;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author nguyentruc
 */
@WebServlet(name = "CreateRecipeController", urlPatterns = {"/CreateRecipeController"})
public class CreateRecipeController extends HttpServlet {

    private static final String ERROR = "createrecipe.jsp";
    private static final String SUCCESS = "createISC.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        RecipeDTO recipe = null;
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

        if (user != null) {
            try {
                int userID = user.getUserID();
                String recipeName = request.getParameter("recipeName");
                Date datePost = new Date();
                String description = request.getParameter("description");
                String[] meal = request.getParameterValues("meal");
                double cookingTime = Double.parseDouble(request.getParameter("cookingTime"));
                String image = request.getParameter("image");
                RecipeDAO rdao = new RecipeDAO();
                recipe = new RecipeDTO(userID, recipeName, datePost, description, cookingTime, image,Arrays.toString(meal).trim(), false);
                boolean checkInsert = rdao.insertRecipe(recipe);    

                if (checkInsert) {
                    NutritionalDAO nutritionaldao = new NutritionalDAO();
                    List<NutritionalDTO> listNutritional = nutritionaldao.getAllNutritional();
                    if (listNutritional.size() > 0) {
                        request.setAttribute("LIST_NUTRITIONAL", listNutritional);
                    }
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Unknown error");
                }
            } catch (Exception e) {
                log("Error at CreateRecipeController: " + e.toString());
            } finally {
                request.getSession().setAttribute("recipe", recipe);
                request.getRequestDispatcher(url).forward(request, response);
            }
        } else {
            response.sendRedirect("error.jsp");
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
