/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp.ro.Ingredient.IngredientDAO;
import swp.ro.Ingredient.IngredientDTO;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.Step.StepDAO;
import swp.ro.Step.StepDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditRecipeController", urlPatterns = {"/EditRecipeController"})
public class EditRecipeController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    //DOI SUCCESS
    private static final String SUCCESS = "MyRecipeController";

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
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            //Start Edit Recipe
            RecipeDAO recipeDao = new RecipeDAO();
            RecipeDTO recipeDTO = null;
            boolean checkRecipeFlag = false;
            int recipeID = Integer.parseInt(request.getParameter("recipeID"));
            int userID = user.getUserID();
            Date datePost = Date.valueOf(request.getParameter("datePost"));
            String recipeName = request.getParameter("recipeName");
            String description = request.getParameter("description");
            double cookingTime = Double.parseDouble(request.getParameter("cookingTime"));
            String imageRecipe = request.getParameter("image");
            String[] meal = request.getParameterValues("meal");
            recipeDTO = new RecipeDTO(recipeID, userID, recipeName, datePost, description, cookingTime, imageRecipe, Arrays.toString(meal), false);
            checkRecipeFlag = recipeDao.update(recipeDTO);
            //End Edit Recipe
            //Start Edit Step
            boolean checkStepFlag = false;
            StepDAO stepDao = new StepDAO();
            StepDTO stepDto = null;
            List<StepDTO> listStep = stepDao.getStepsByRecipeID(recipeID);
            String[] stepNumber = request.getParameterValues("stepNumber");
            String[] instructions = request.getParameterValues("instructions");
            for (int i = 0; i < stepNumber.length; i++) {
                if (listStep.size() <= i) {
                    int lenght = stepNumber.length;
                    stepDto = new StepDTO(0, recipeID, stepNumber[lenght - 1], instructions[lenght - 1]);
                    checkStepFlag = stepDao.insertStep(stepDto);
                } else {
                    stepDto = new StepDTO(userID, recipeID, stepNumber[i], instructions[i]);
                    checkStepFlag = stepDao.updateStep(stepDto);
                }
            }
            //End Edit Step
            //End Edit Step
            //Start Edit Ingredient
            boolean checkIngredientFlag = false;
            IngredientDAO ingredientDao = new IngredientDAO();
            IngredientDTO ingredientDto = null;
            List<IngredientDTO> listIngredient = ingredientDao.getIngredientByRecipeID(recipeID);
            
            String[] ingredientID = request.getParameterValues("ingredientID");
            String[] ingredientName = request.getParameterValues("ingredientName");
            String[] quantity = request.getParameterValues("quantity");
            String[] unit = request.getParameterValues("unit");
            for (int i = 0; i < ingredientName.length; i++) {
                if (listIngredient.size() <= i) {
                    int length = ingredientName.length;
                    ingredientDto = new IngredientDTO(recipeID, ingredientName[length - 1], recipeID, Float.parseFloat(quantity[length - 1]), unit[length - 1]);
                    checkIngredientFlag = ingredientDao.createIngredient(ingredientDto);
                } else {
                    ingredientDto = new IngredientDTO(Integer.parseInt(ingredientID[i]), ingredientName[i], recipeID, Float.parseFloat(quantity[i]), unit[i]);
                    checkIngredientFlag = ingredientDao.updateIngredient(ingredientDto);
                }
            }
            //End Edit Ingredient
            //Check for SUCCESS 
            if (checkRecipeFlag && checkStepFlag && checkIngredientFlag) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
