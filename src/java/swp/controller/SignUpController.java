/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;

/**
 *
 * @author My PC
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

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
        UserDTO user_1 = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
        String op = request.getParameter("op");
        if (user_1 == null) {
            switch (op) {
                case "SignUp": {
                    try {
                        String gmail = request.getParameter("gmail");
                        String password = request.getParameter("password");
                        String Cpassword = request.getParameter("Cpassword");
                        UserDAO uDAO = new UserDAO();
                        UserDTO user = uDAO.checkGmail(gmail);
                        if (gmail == null) {
                            request.setAttribute("message", "Plz fill the box");
                            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                        } else if (!password.equals(Cpassword)) {
                            request.setAttribute("message", "The password doesnn't match");
                            request.getRequestDispatcher("SignUp.jsp").forward(request, response);

                        } else {
                            if (user == null) {
                                uDAO.signUp(gmail, password);
                                response.sendRedirect("mainpage.jsp");
                            } else {
                                request.setAttribute("message", "Email has been signed up");
                                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                            }
                        }
                    } catch (Exception e) {

                    }
                    break;
                }
                case "Cancel": {
                    response.sendRedirect("mainpage.jsp");
                    break;
                }
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
