/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;
import swp.ro.gmail.SendEmail;

/**
 *
 * @author My PC
 */
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/ForgotPasswordController"})
public class ForgotPasswordController extends HttpServlet {

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

        String op = request.getParameter("op");
        switch (op) {
            case "Confirm": {
                try {
                    String gmail = request.getParameter("gmail");

                    SendEmail sm = new SendEmail();
                    String code = sm.getRandom();

                    UserDTO user = new UserDTO(gmail, code);

                    boolean test = sm.sendEmail(user);
                    if (test) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("code.jsp");
                    }
                } catch (Exception e) {
                }
                break;
            }

            case "Cancel": {
                response.sendRedirect("MainController");
                break;
            }

            case "Verify": {
                try {
                    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                    String code = request.getParameter("code");

                    Timer time = new Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            user.setCode(null);
                            time.cancel();
                        }
                    }, 30 * 1000);

                    if (code.equalsIgnoreCase(user.getCode())) {
                        response.sendRedirect("resetPass.jsp");
                    } else {
                        request.setAttribute("failed", "Wrong code");
                        request.getRequestDispatcher("code.jsp").forward(request, response);
                    }
                } catch (Exception e) {

                }

                break;
            }

            case "Back To Gmail": {
                request.getSession().invalidate();
                response.sendRedirect("forgotPassword.jsp");
                break;
            }

            case "Resend": {
                try {
                    String gmail = request.getParameter("gmail");

                    SendEmail sm = new SendEmail();
                    String code = sm.getRandom();

                    UserDTO user = new UserDTO(gmail, code);

                    boolean test = sm.sendEmail(user);
                    if (test) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("code.jsp");
                    }
                } catch (Exception e) {
                }
            }

            case "Reset": {
                try {
                    String gmail = request.getParameter("gmail");

                    String Npassword = request.getParameter("Npassword");
                    String Cpassword = request.getParameter("Cpassword");
                    UserDAO uDAO = new UserDAO();

                    if (!Npassword.equals(Cpassword)) {
                        request.setAttribute("failed", "The password doesn't match");
                        request.getRequestDispatcher("resetPass.jsp").forward(request, response);
                    } else {
                        uDAO.resetPass(Npassword, gmail);
                        request.getSession().invalidate();
                        response.sendRedirect("MainController");
                    }
                } catch (Exception e) {

                }
                break;
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
