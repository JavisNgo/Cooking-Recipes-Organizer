/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.MealPlanning.MealPlanningDAO;
import swp.ro.MealPlanning.MealPlanningDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "SaveRecipePlanController", urlPatterns = {"/SaveRecipePlanController"})
public class SaveRecipePlanController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
        if (user != null) {
            try {
                int userID = user.getUserID();
                int svRecipeID = Integer.parseInt(request.getParameter("svRecipeID"));
              
                MealPlanningDAO dao = new MealPlanningDAO();
                MealPlanningDTO mp = new MealPlanningDTO();
              
//                if (check == null) {
                    mp.setUserID(userID);
                    mp.setSavedRecipeID(svRecipeID);
                   
                    
                    response.sendRedirect("MainController?action=PlanningPage&userID=" + userID);
                   
//                } else {
//                    request.setAttribute("failed", "Recipe already to use.");
//                    request.getRequestDispatcher("plantest.jsp?userID=" + userID).forward(request, response);
//                }
            } catch (Exception e) {
                log("Error at SaveRecipePlanController:" + e.toString());
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
