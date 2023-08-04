/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.Category.CategoryDAO;
import swp.ro.Category.CategoryDTO;
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
 * @author My PC
 */
@WebServlet(name = "CreateISCController", urlPatterns = {"/CreateISCController"})
public class CreateISCController extends HttpServlet {

    private static final String ERROR = "createISC.jsp";
    private static final String SUCCESS = "MainController?action=RecipeDetail&recipeID=";

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
        if (user != null) {
        try {
            
            RecipeDAO rdao = new RecipeDAO();
            RecipeDTO rdto = new RecipeDTO();
            int recipeID = rdao.getNewRecipeID(user.getUserID());
            //IGREDIENT
            boolean checkFlag = false;
            IngredientDAO ingredientdao = new IngredientDAO();
            //ĐỔI RECIPE ID
            //Value
            String[] quantityValue = request.getParameterValues("quantity");
            String[] ingredientName = request.getParameterValues("ingredientName");
            String[] unit = request.getParameterValues("unit");
            for (int i = 0; i< ingredientName.length; i++){
                checkFlag = ingredientdao.createIngredient(new IngredientDTO(0, ingredientName[i], 
                                                recipeID, Float.parseFloat(quantityValue[i]), unit[i]));
                if(checkFlag == false) {
                    url = ERROR;
                    request.setAttribute("message", "Error at this");
                    break;
                }
            }
            //STEP
            String[] stepNumber = request.getParameterValues("stepNumber");
            String[] instructions = request.getParameterValues("instructions");
            StepDAO stepDAO = new StepDAO();
            StepDTO step = new StepDTO();
            for (int i = 0; i < stepNumber.length; i++) {
                step.setRecipeID(recipeID);
                step.setInstructions(instructions[i]);
                step.setStepNumber(stepNumber[i]);
                stepDAO.addStep(step);
            }
            response.sendRedirect(SUCCESS+ recipeID);
        } catch (Exception e) {
            log("Error at CreateRecipeController: " + e.toString());
        } 
    }else {
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
