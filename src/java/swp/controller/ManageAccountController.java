/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ManageAccountController", urlPatterns = {"/ManageAccountController"})
public class ManageAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "LoadUsersController";

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
        HttpSession session = request.getSession();
        UserDTO admin = (UserDTO) session.getAttribute("LOGIN_USER");
        UserDTO user = null;
        UserDAO dao = new UserDAO();
        try {
            if (admin != null && admin.getRole().equalsIgnoreCase("AD")) {
                String userID = request.getParameter("userID");
                String action = request.getParameter("action");
                switch (action) {

                    case "Block":
                        if (dao.blockUser(Integer.parseInt(userID), false)) {
                            url = SUCCESS;
                        } else {
                            url = ERROR;
                        }
                        break;

                    case "Unblock":
                        if (dao.blockUser(Integer.parseInt(userID), true)) {
                            url = SUCCESS;
                        } else {
                            url = ERROR;
                        }
                        break;

                    case "Update":
                        int id = Integer.parseInt(userID);
                        String userName = request.getParameter("userName");
                        String gmail = request.getParameter("gmail");
                        String role = request.getParameter("role");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date dob = sdf.parse(request.getParameter("dob"));
                        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                        String phone = request.getParameter("phone");
                        String password = request.getParameter("password");
                        String imageUser = request.getParameter("imageUser");
                        boolean status = Boolean.parseBoolean(request.getParameter("status"));
                        user = new UserDTO(id, userName, dob, gender, phone, gmail, password, imageUser, role, status);

                        if (dao.updateByAdmin(user)) {
                            request.setAttribute("message", "alert('Update Success')");
                            url = SUCCESS;
                        }
                        break;
                    case "Detail":
                        user = dao.getOne(Integer.parseInt(userID));
                        if (user != null) {
                            request.setAttribute("user_detail", user);
                            url = "manageUserDetail.jsp";
                        }
                        break;
                    case "Create":
                        url = "CreateAccountController";
                        break;
                    default:
                        throw new Exception();
                }
            } else {
                request.setAttribute("message", "You don't have permission");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Co loi tai ManageAccountController");
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
