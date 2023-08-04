/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.Category.CategoryDAO;
import swp.ro.Category.CategoryDTO;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;

/**
 *
 * @author phamt
 */
@WebServlet(name = "FilterController", urlPatterns = {"/FilterController"})
public class FilterController extends HttpServlet {

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
        try {
            String[] categories = request.getParameterValues("categories");
            String[] meal = request.getParameterValues("meal");
            RecipeDAO rDAO = new RecipeDAO();
            CategoryDAO cDAO = new CategoryDAO();
            if (categories == null && meal == null) {

                request.setAttribute("Failed", "Please check the category or meal to filter.");
                request.getRequestDispatcher("MainController?action=RecipePage").forward(request, response);

            } else if (categories == null && meal != null) {
                List<RecipeDTO> listMeal = rDAO.getMealFromFilter(Arrays.toString(meal));
                request.setAttribute("listMeal", listMeal);
                request.getRequestDispatcher("filterPage.jsp").forward(request, response);

            } else if (categories != null && meal == null) {
                
                List<RecipeDTO> dfList = new ArrayList<>();
                for (int i = 0; i < categories.length; i++) {
                    String category = categories[i].replaceAll("[\\[\\],]", "");
                    List<RecipeDTO> listCate = cDAO.getCategoriesFromFilter(category);
                    if(listCate == null) {
                        request.setAttribute("FAILED", "Don't have anything here");
                        dfList = null;
                        request.getRequestDispatcher("filterPage.jsp");
                        break;
                    }

                    
                    for (RecipeDTO obj : listCate) {
                        dfList.add(obj);
                    }                                    
                }
                List<RecipeDTO> listCate = cDAO.getCategoriesFromFilter1(categories);
                 request.setAttribute("dfList", dfList);
                request.getRequestDispatcher("filterPage.jsp").forward(request, response);
            } else {
                List<RecipeDTO> bothList = new ArrayList<>();
                String meall = Arrays.toString(meal);
                for (int i = 0; i < categories.length; i++) {
                    String category = categories[i].replaceAll("[\\[\\],]", "");                  
                    List<RecipeDTO> bothL = cDAO.getBothFromFilter(meall, category);
                    for (RecipeDTO obj : bothL) {
                        bothList.add(obj);
                    }
                    request.setAttribute("bothList", bothList);
                }
                request.getRequestDispatcher("filterPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
