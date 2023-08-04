/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package swp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
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
 * @author Admin
 */
@WebServlet(name = "CreateAccountController", urlPatterns = {"/CreateAccountController"})
public class CreateAccountController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "LoadAccountsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDTO acc = null;
        boolean checkValidation = true;
        HttpSession session = request.getSession();
        UserDTO admin = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            if ( admin != null && admin.getRole().equalsIgnoreCase("AD") ) {
                String userName = request.getParameter("userName");
                String gmail = request.getParameter("gmail");
                String role = request.getParameter("role");
                String dobString = request.getParameter("dob");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(dobString);
                boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");
                String imageUser = request.getParameter("imageUser");
                boolean status = Boolean.parseBoolean(request.getParameter("status"));
                UserDAO dao = new UserDAO();
                if (!Pattern.matches("^[A-Za-z0-9]+@gmail\\.com$", gmail)) {
                    request.setAttribute("message", "alert('Email is not valid')");
                    checkValidation = false;
                }
                if (dao.checkDuplicate(gmail)) {
                    request.setAttribute("message", "alert('Account existed!')");
                    checkValidation = false;
                }
                if (password.length() < 5) {
                    request.setAttribute("message", "alert('Password must contain at least 5 characters')");
                    checkValidation = false;
                }
                if (userName.length() < 5) {
                    request.setAttribute("message", "alert('Name must contain at least 3 characters')");
                    checkValidation = false;
                }
                if (!Pattern.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b", phone)) {
                    request.setAttribute("message", "alert('Invalid phone number')");
                    checkValidation = false;
                }
                if (checkValidation) {
                    acc = new UserDTO(0, userName, dob, gender, phone, gmail, password, imageUser, role, status);

                    boolean checkCreate = dao.createUser(acc);
                    if (checkCreate) {
                        request.setAttribute("message", "alert('Create Success')");
                        url = SUCCESS;
                    }
                }
            } else {
                request.setAttribute("message", "You don't have permission");
            }
        } catch (Exception e) {
            log("Error at CreateControler");
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
