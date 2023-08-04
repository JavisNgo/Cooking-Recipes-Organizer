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
import javax.servlet.http.HttpSession;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;

/**
 *
 * @author Thành Long
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String US = "US";
    private static final String US_PAGE = "mainpage.jsp";
    private static final String AD = "AD";
    private static final String AD_PAGE = "LoadDashboardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDTO user = (UserDTO) request.getAttribute("LOGIN_USER");
        String op = request.getParameter("op");
        if (user == null) {
            switch (op) {
                case "Login": {
                    try {
                        String gmail = request.getParameter("gmail");
                        String password = request.getParameter("password");
                        UserDAO dao = new UserDAO();
                        UserDTO loginUser = dao.login(gmail, password);
                        //xác thực ở đây nè
                        if (loginUser == null) {
                            request.setAttribute("ERROR", "Incorrect Email or Password");
                            url = LOGIN_PAGE;
                        } else {
                            // phân quyền ở khúc này nè
                            String role = loginUser.getRole();
                            HttpSession session = request.getSession();
                            session.setAttribute("LOGIN_USER", loginUser);
                            if (US.equals(role)) {
                                url = US_PAGE;
                            } else if (AD.equals(role)) {
                                url = AD_PAGE;
                            } else {
                                request.setAttribute("ERROR", "Your role is not support yet!");
                            }
                        }
                    } catch (Exception e) {
                        log("Error at LoginController: " + e.toString());
                    } finally {
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                    break;
                }
                case "Cancel": {
                    response.sendRedirect("mainpage.jsp");
                    break;
                }
            }

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
