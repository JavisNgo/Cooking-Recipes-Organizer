package swp.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp.ro.Recipe.RecipeDAO;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDAO;
import swp.ro.User.UserDTO;
import swp.ro.feedback.FeedBackDAO;
import swp.ro.feedback.FeedBackDTO;
import swp.ro.rating.RatingDAO;
import swp.ro.rating.RatingDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadDashboardController", urlPatterns = {"/LoadDashboardController"})
public class LoadDashboardController extends HttpServlet {

    private static final String SUCCESS = "dashboard.jsp";
    private static final String ERROR = "error.jsp";

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
        try {
            if (admin != null && admin.getRole().equalsIgnoreCase("AD")) {
                // Total user
                UserDAO userdao = new UserDAO();
                int totalUser = userdao.countUsers();

                //Count and Load recent recipes
                RecipeDAO recipedao = new RecipeDAO();
                List<RecipeDTO> listRecipe = recipedao.recentRecipes();
                int totalRecipe = recipedao.countRecipes();

                //Count and Load recent feedbacks
                FeedBackDAO feedbackdao = new FeedBackDAO();
                List<FeedBackDTO> listFeedBack = feedbackdao.getRecentFeedbacks();
                int totalFeedBack = feedbackdao.getTotalComments();

                //Get top 5 of recipe
                RatingDAO ratingdao = new RatingDAO();
                List<RatingDTO> listTop5 = ratingdao.listRecipesTop5();

                //Get top 3 users create most recipes
                Map<String, Integer> listTop3Most = userdao.Top3UsersCreateMostRecipes();

                if (totalUser != 0 && !listRecipe.isEmpty() && totalRecipe != 0 && !listFeedBack.isEmpty()
                        && totalFeedBack != 0 && !listTop5.isEmpty() && !listTop3Most.isEmpty()) {
                    request.setAttribute("TOTAL_USER", totalUser);
                    request.setAttribute("LIST_RECENT_RECIPE", listRecipe);
                    request.setAttribute("LIST_RECENT_FEEDBACK", listFeedBack);
                    request.setAttribute("TOTAL_RECIPE", totalRecipe);
                    request.setAttribute("TOTAL_FEEDBACK", totalFeedBack);
                    request.setAttribute("LIST_TOP_5", listTop5);
                    request.setAttribute("LIST_TOP_3", listTop3Most);
                    url = SUCCESS;
                } else {
                    request.setAttribute("message", "Error at LoadDashboardController");
                }
            } else {
                request.setAttribute("message", "You don't have permission");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
