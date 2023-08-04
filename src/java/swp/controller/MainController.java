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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;
import swp.ro.rating.RatingDAO;

/**
 *
 * @author Thành Long
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String MAIN_PAGE = "mainpage.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "LogOut";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String SEARCH = "SearchHome";
    private static final String SEARCH_CONTROLLER = "SearchHomeController";
    private static final String FEEDBACK = "Feedback";
    private static final String FEEDBACK_CONTROLLER = "FeedBackController";
    private static final String FAVORITE = "Favorite";
    private static final String FAVORITE_CONTROLLER = "FavoriteRecipesController";
    private static final String REMOVE = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveController";
    private static final String RATING = "Rating";
    private static final String RATING_CONTROLLER = "RatingController";
    private static final String RECIPE_DETAIL = "RecipeDetail";
    private static final String RECIPE_DETAIL_CONTROLLER = "RecipeDetailController";
    private static final String CHANGE_PASSWORD = "ChangePassword";
    private static final String CHANGE_PASSWORD_CONTROLLER = "ChangePasswordController";
    private static final String RECIPE_PAGE = "RecipePage";
    private static final String RECIPE_PAGE_CONTROLLER = "RecipePageController";
    private static final String ADD_RECIPE = "Add Recipe";
    private static final String ADD_RECIPE_CONTROLLER = "AddRecipeController";
    private static final String SAVED_RECIPE = "SavedRecipe";
    private static final String SAVED_RECIPE_CONTROLLER = "SavedRecipeController";
    private static final String REMOVE_SAVED_RECIPE = "RemoveSavedRecipe";
    private static final String REMOVE_SAVED_RECIPE_CONTROLLER = "RemoveSavedRecipeController";
    private static final String REMOVE_FAVORITE_RECIPE = "RemoveFavoriteRecipe";
    private static final String REMOVE_FAVORITE_RECIPE_CONTROLLER = "RemoveFavoriteRecipeController";
    private static final String SAVED_PAGE = "SavedPage";
    private static final String SAVED_PAGE_CONTROLLER = "SavedPageController";
    private static final String REMOVE_FROM_SAVED = "RemoveFromSaved";
    private static final String REMOVE_FROM_SAVED_CONTROLLER = "RemoveFromSavedController";
    private static final String FAVORITE_PAGE = "FavoritePage";
    private static final String FAVORITE_PAGE_CONTROLLER = "FavoritePageController";
    private static final String REMOVE_FROM_FAVPROTE = "RemoveFromFavorite";
    private static final String REMOVE_FROM_FAVORITE_CONTROLLER = "RemoveFromFavoriteController";
    private static final String PLANNING_PAGE = "PlanningPage";
    private static final String PLANNING_PAGE_CONTROLLER = "PlanningPageController";
    private static final String CREATE_RECIPE = "CreateRecipe";
    private static final String CREATE_RECIPE_CONTROLLER = "CreateRecipeController";
    private static final String CREATE_ISC = "CreateISC";
    private static final String CREATE_ISC_CONTROLLER = "CreateISCController";
    private static final String MY_PROFILE = "MyProfile";
    private static final String MY_PROFILE_CONTROLLER = "MyProfileController";
    private static final String SAVE_PROFILE = "SaveProfile";
    private static final String SAVE_PROFILE_CONTROLLER = "SaveProfileController";
    private static final String SIGNUP = "SignUp";
    private static final String SIGNUP_CONTROLLER = "SignUpController";
    private static final String FORGOTPASSWORD = "ForgotPassword";
    private static final String FORGOTPASSWORD_CONTROLLER = "ForgotPasswordController";
    private static final String ADDRECIPE_PAGE = "AddRecipePage";
    private static final String ADDRECIPEPAGE_CONTROLLER = "AddRecipePageController";
    private static final String MY_RECIPE = "MyRecipe";
    private static final String MY_RECIPE_CONTROLLER = "MyRecipeController";
    private static final String SAVE_PASSWORD = "SavePassword";
    private static final String SAVE_PASSWORD_CONTROLLER = "SavePasswordController";
    private static final String LOAD_CATEGORY = "LoadCategories";
    private static final String LOAD_CATEGORY_CONTROLLER = "LoadCategoriesController";
    private static final String LOAD_NUTRITIONAL = "LoadNutritrional";
    private static final String LOAD_NUTRITIONAL_CONTROLLER = "LoadNutritionalController";
    private static final String SEARCH_BY_CATEGORY = "SearchByCategory";
    private static final String SEARCH_BY_CATEGORY_CONTROLLER = "SearchByCategoryController";
    private static final String REMOVE_RECIPE_BY_ID = "RemoveRecipeByRecipeID";
    private static final String REMOVE_RECIPE_BY_ID_CONTROLLER = "RemoveRecipeByRecipeIDController";
    //Admin flow
    private static final String LOAD_USERS = "LoadUsers";
    private static final String LOAD_USERS_CONTROLLER = "LoadUsersController";
    private static final String LOAD_RECIPES = "LoadRecipes";
    private static final String LOAD_RECIPES_CONTROLLER = "LoadRecipesController";
    private static final String LOAD_FEEDBACKS = "LoadFeedbacks";
    private static final String LOAD_FEEDBACKS_CONTROLLER = "LoadFeedbacksController";
    private static final String LOAD_CATEGORY_OF_RECIPE = "LoadCategoryOfRecipe";
    private static final String LOAD_CATEGORY_OF_RECIPE_CONTROLLER = "LoadCategoryOfRecipeController";
    private static final String LOAD_DASHBOARD = "LoadDashboard";
    private static final String LOAD_DASHBOARD_CONTROLLER = "LoadDashboardController";
    private static final String LOAD_EDIT_RECIPE = "LoadRecipeDetailForEdit";
    private static final String LOAD_EDIT_RECIPE_CONTROLLER = "LoadRecipeDetailForEditController";
    private static final String EDIT_RECIPE = "EditRecipe";
    private static final String EDIT_RECIPE_CONTROLLER = "EditRecipeController";
    private static final String SAVE_RECIPE_PLAN = "SaveRecipePlan";
    private static final String SAVE_RECIPE_PLAN_CONTROLLER = "SaveRecipePlanController";
 
    private static final String PLANNING = "Planning";
    private static final String PLANNING_CONTROLLER = "PlanningController";
    private static final String DELETE_PLAN = "DeletePlan";
    private static final String DELETE_PLAN_CONTROLLER = "DeletePlanController";
    
    private static final String FILTER = "Filter";
    private static final String FILTER_CONTROLLER = "FilterController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                RecipeDAO dao = new RecipeDAO();
                RatingDAO daoRating = new RatingDAO();
                UserDAO daoUser = new UserDAO();
                Map<Integer, Double> listRatingTop6Recipe = daoRating.getTop6Recipe();
                Map<Integer, Double> listRatingRandomRecipe = daoRating.getRatingRecipe();
                List<RecipeDTO> listRecipeTop6 = dao.getListRecipeHome(listRatingTop6Recipe);
                List<RecipeDTO> listRandomRecipe = dao.getRandomListRecipe();
                List<UserDTO> listUser = daoUser.getListUser();
                HttpSession session = request.getSession();
                session.setAttribute("AVG_TOP_6_RATING_RECIPE", listRatingTop6Recipe);
                session.setAttribute("AVG_RANDOM_RATING_RECIPE", listRatingRandomRecipe);
                session.setAttribute("LIST_TOP_6_RECIPE", listRecipeTop6);
                session.setAttribute("LIST_RANDOM_RECIPE", listRandomRecipe);
                session.setAttribute("LIST_USER", listUser);
                url = MAIN_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (FEEDBACK.equals(action)) {
                url = FEEDBACK_CONTROLLER;
            } else if (SAVED_RECIPE.equals(action)) {
                url = SAVED_RECIPE_CONTROLLER;
            } else if (FAVORITE.equals(action)) {
                url = FAVORITE_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (RATING.equals(action)) {
                url = RATING_CONTROLLER;
            } else if (CHANGE_PASSWORD.equals(action)) {
                url = CHANGE_PASSWORD_CONTROLLER;
            } else if (RECIPE_DETAIL.equals(action)) {
                url = RECIPE_DETAIL_CONTROLLER;
            } else if (RECIPE_PAGE.equals(action)) {
                url = RECIPE_PAGE_CONTROLLER;
            } else if (ADD_RECIPE.equals(action)) {
                url = ADD_RECIPE_CONTROLLER;
            } else if (REMOVE_SAVED_RECIPE.equals(action)) {
                url = REMOVE_SAVED_RECIPE_CONTROLLER;
            } else if (REMOVE_FAVORITE_RECIPE.equals(action)) {
                url = REMOVE_FAVORITE_RECIPE_CONTROLLER;
            } else if (SAVED_PAGE.equals(action)) {
                url = SAVED_PAGE_CONTROLLER;
            } else if (REMOVE_FROM_SAVED.equals(action)) {
                url = REMOVE_FROM_SAVED_CONTROLLER;
            } else if (FAVORITE_PAGE.equals(action)) {
                url = FAVORITE_PAGE_CONTROLLER;
            } else if (REMOVE_FROM_FAVPROTE.equals(action)) {
                url = REMOVE_FROM_FAVORITE_CONTROLLER;
            } else if (PLANNING_PAGE.equals(action)) {
                url = PLANNING_PAGE_CONTROLLER;
            } else if (CREATE_RECIPE.equals(action)) {
                url = CREATE_RECIPE_CONTROLLER;
            } else if (CREATE_ISC.equals(action)) {
                url = CREATE_ISC_CONTROLLER;
            } else if (MY_PROFILE.equals(action)) {
                url = MY_PROFILE_CONTROLLER;
            } else if (SAVE_PROFILE.equals(action)) {
                url = SAVE_PROFILE_CONTROLLER;
            } else if (SIGNUP.equals(action)) {
                url = SIGNUP_CONTROLLER;
            } else if (FORGOTPASSWORD.equals(action)) {
                url = FORGOTPASSWORD_CONTROLLER;
            } else if (ADDRECIPE_PAGE.equals(action)) {
                url = ADDRECIPEPAGE_CONTROLLER;
            } else if (MY_RECIPE.equals(action)) {
                url = MY_RECIPE_CONTROLLER;
            } else if (SAVE_PASSWORD.equals(action)) {////
                url = SAVE_PASSWORD_CONTROLLER;
            } else if (LOAD_CATEGORY.equals(action)) {
                url = LOAD_CATEGORY_CONTROLLER;
            } else if (LOAD_USERS.equals(action)) {
                url = LOAD_USERS_CONTROLLER;
            } else if (LOAD_RECIPES.equals(action)) {
                url = LOAD_RECIPES_CONTROLLER;
            } else if (LOAD_FEEDBACKS.equals(action)) {
                url = LOAD_FEEDBACKS_CONTROLLER;
            } else if (LOAD_CATEGORY_OF_RECIPE.equals(action)) {
                url = LOAD_CATEGORY_OF_RECIPE_CONTROLLER;
            } else if (LOAD_NUTRITIONAL.equals(action)) {
                url = LOAD_NUTRITIONAL_CONTROLLER;
            } else if (SEARCH_BY_CATEGORY.equals(action)) {
                url = SEARCH_BY_CATEGORY_CONTROLLER;
            } else if (LOAD_DASHBOARD.equals(action)) {
                url = LOAD_DASHBOARD_CONTROLLER;
            } else if (LOAD_EDIT_RECIPE.equals(action)) {
                url = LOAD_EDIT_RECIPE_CONTROLLER;
            } else if (EDIT_RECIPE.equals(action)) {
                url = EDIT_RECIPE_CONTROLLER;
            } else if (REMOVE_RECIPE_BY_ID.equals(action)) {
                url = REMOVE_RECIPE_BY_ID_CONTROLLER;
            }else if(PLANNING_PAGE.equals(action)){
                url=PLANNING_PAGE_CONTROLLER;
            } else if(SAVE_RECIPE_PLAN.equals(action)){
                url=SAVE_RECIPE_PLAN_CONTROLLER;
            }else if(FILTER.equals(action)){
                url = FILTER_CONTROLLER;
            }
            else {
                request.setAttribute("ERROR", "Your ACTION is not support!!!");
            }
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
