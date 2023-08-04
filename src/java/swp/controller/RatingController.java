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
import swp.ro.rating.RatingDAO;
import swp.ro.rating.RatingDTO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "RatingController", urlPatterns = {"/RatingController"})
public class RatingController extends HttpServlet {

        private static final String SUCCESS = "MainController?action=RecipeDetail&recipeID=";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
        if (user != null) {
            int userID = user.getUserID();
        String op = request.getParameter("op");
        switch (op) {
            case "one": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 1;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "two": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 2;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                       response.sendRedirect(SUCCESS + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "three": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 3;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                       response.sendRedirect(SUCCESS + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "four": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 4;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "five": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 5;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(SUCCESS + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
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
