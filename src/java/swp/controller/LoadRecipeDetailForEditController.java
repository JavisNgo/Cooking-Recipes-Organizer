/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package swp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature;
import swp.ro.Ingredient.IngredientDAO;
import swp.ro.Ingredient.IngredientDTO;
import swp.ro.Nutritional.NutritionalDAO;
import swp.ro.Nutritional.NutritionalDTO;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.Step.StepDAO;
import swp.ro.Step.StepDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadRecipeDetailForEditController", urlPatterns = {"/LoadRecipeDetailForEditController"})
public class LoadRecipeDetailForEditController extends HttpServlet {

    private static final String SUCCESS = "editRecipe.jsp";
    private static final String ERROR = "error.jsp";
    private static final String TEST = "editRecipe.jsp";

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
         UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
        if (user != null ) {
         try {      
            int userID = user.getUserID();
            //DOI RECIPE ID
            int recipeID = Integer.parseInt(request.getParameter("recipeID"));
            NutritionalDAO nutritionaldao = new NutritionalDAO();
            List<NutritionalDTO> listNutritional = nutritionaldao.getAllNutritional();
            StepDAO stepdao = new StepDAO();
            List<StepDTO> listStep = stepdao.getStepsByRecipeID(recipeID);
            RecipeDAO recipeDao = new RecipeDAO();
            RecipeDTO recipedto = recipeDao.getOne(recipeID);
            IngredientDAO ingredientDao = new IngredientDAO();
            List<IngredientDTO> listIngredient = ingredientDao.getIngredientByRecipeID(recipeID);
            List<IngredientDTO> getAllIngre = ingredientDao.getAllIngredient();
            if (listNutritional.size() >= 0 && listStep.size() >= 0 && recipedto != null && listIngredient.size() >= 0) {
                request.setAttribute("LIST_NUTRITIONAL", listNutritional);
                request.setAttribute("LIST_STEP", listStep);
                request.setAttribute("LIST_INGREDIENT", listIngredient);
                request.setAttribute("RECIPE_DETAIL", recipedto);
                url = SUCCESS;
            } else {
                request.setAttribute("message", "Error at LoadNutritionalController");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    } else {
            response.sendRedirect(ERROR);
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
