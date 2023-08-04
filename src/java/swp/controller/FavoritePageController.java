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
import swp.ro.FavoriteRecipes.FavoriteRecipesDAO;
import swp.ro.FavoriteRecipes.FavoriteRecipesDTO;
import swp.ro.User.UserDTO;
import swp.ro.savedRecipes.SavedRecipesDAO;
import swp.ro.savedRecipes.SavedRecipesDTO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "FavoritePageController", urlPatterns = {"/FavoritePageController"})
public class FavoritePageController extends HttpServlet {

    
    private static final String SUCCESS="favorite.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=SUCCESS;
        UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");

        if (user != null ) {
         try {      
            int userID = user.getUserID();
            FavoriteRecipesDAO dao=new FavoriteRecipesDAO();
            List<FavoriteRecipesDTO> list=dao.getFavorite(userID);
            request.setAttribute("list", list);
            request.setAttribute("size", list.size());
          
        } catch (Exception e) {
            
        }finally{
               request.getRequestDispatcher(url).forward(request, response);
         }
    }else {
            response.sendRedirect("error.jsp"); //CHUYEN DEN TRANG LOI 
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
