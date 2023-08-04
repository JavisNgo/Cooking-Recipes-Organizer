/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.feedback;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swp.ro.Recipe.RecipeDTO;

/**
 *
 * @author truc0
 */
public class FeedBackDAO {
     private static final String GET_ALL_FEEDBACK = "SELECT * FROM [Feedback] a JOIN [Recipe] b ON a.recipeID = b.recipeID JOIN [User] c ON a.userID = c.userID ";
    private static final String GET_ONE = "select * from FeedBack a "
            + "join [Recipe] b on a.recipeID = b.recipeID "
            + "join [User] c on a.userID = c.userID "
            + "where a.feedBackID = ?";
    private static final String UPDATE = "update Feedback set [content] = ?, [recipeID] = ?, [userID] = ?, [feedbackDate] = ?, [status] = ? where [feedBackID] = ?";
    private static final String DELETE = "DELETE [Feedback] WHERE feedbackID = ?";
    private static final String RECENT_FEEDBACKS = "SELECT TOP 5 * FROM FeedBack a \n"
            + "JOIN [Recipe] b ON a.recipeID = b.recipeID \n"
            + "JOIN [User] c ON a.userID = c.userID \n"
            + "ORDER BY a.feedBackDate DESC";
    private static final String GET_COMMENT = "select * from FeedBack a "
                + "join Recipe b on a.recipeID = b.recipeID "
                + "join [User] c on a.userID = c.userID "
                + "where a.recipeID = ? and a.[status] = 1";
    private static final String ADD_COMMENT = "insert [FeedBack] values(?, ?, ?, ?, 0)";
    private static final String TOTAL_COMMENT = "select count(feedBackID) as totalC from [feedBack]";
    private static final String ADDCOMMENTS_AD="update feedBack set [status] = 1 where feedBackID = ?";
    private static final String COUNT_COMMENT = "SELECT COUNT(*) AS totalComment FROM feedback WHERE recipeID=?";

    
     public Map<Integer, Integer> getListComment(List<RecipeDTO> list) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        Map<Integer, Integer> map = new HashMap<>();
        int totalComment = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                for (RecipeDTO recipe : list) {
                    ptm = conn.prepareStatement(COUNT_COMMENT);
                    ptm.setInt(1, recipe.getRecipeID());
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                    totalComment = rs.getInt("totalComment");
                    map.put(recipe.getRecipeID(), totalComment);
                    }
                }      
        } 
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return map;
    }
    public List<FeedBackDTO> getAllFeedback() throws SQLException, ClassNotFoundException {
        List<FeedBackDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(GET_ALL_FEEDBACK);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            int feedBackID = rs.getInt("feedbackID");
            String content = rs.getString("content");
            int recipeID = rs.getInt("recipeID");
            int userID = rs.getInt("userID");
            Date feedbackDate = rs.getDate("feedbackDate");
            boolean status = rs.getBoolean("status");
            String recipeName = rs.getString("recipeName");
            String userName = rs.getString("userName");
            list.add(new FeedBackDTO(feedBackID, content, recipeID, userID, feedbackDate, status, recipeName, userName));
        }
        con.close();
        return list;
    }

    public List<FeedBackDTO> getComments(int recipeID) throws SQLException, ClassNotFoundException {
        List<FeedBackDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FeedBack a "
                + "join Recipe b on a.recipeID = b.recipeID "
                + "join [User] c on a.userID = c.userID "
                + "where a.recipeID = ? and a.[status] = 1");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FeedBackDTO feedback = new FeedBackDTO();
            feedback.setFeedBackID(rs.getInt("feedBackID"));
            feedback.setContent(rs.getString("content"));
            feedback.setUserID(rs.getInt("userID"));
            feedback.setUserName(rs.getString("userName"));
            feedback.setFeedbackDate(rs.getDate("feedbackDate"));
            feedback.setRecipeID(rs.getInt("recipeID"));
            feedback.setStatus(rs.getBoolean("status"));
            list.add(feedback);
        }
        con.close();
        return list;
    }

    public FeedBackDTO getOne(int feedBackID) throws SQLException, ClassNotFoundException {
        FeedBackDTO feedback = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(GET_ONE);
            ptm.setInt(1, feedBackID);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String content = rs.getString("content");
                int recipeID = rs.getInt("recipeID");
                int userID = rs.getInt("userID");
                Date feedbackDate = rs.getDate("feedbackDate");
                boolean status = rs.getBoolean("status");
                String recipeName = rs.getString("recipeName");
                String userName = rs.getString("userName");
                feedback = new FeedBackDTO(feedBackID, content, recipeID, userID, feedbackDate, status, recipeName, userName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return feedback;
    }

    public void addComments(FeedBackDTO fb) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(ADD_COMMENT);
        stm.setString(1, fb.getContent());
        stm.setInt(2, fb.getRecipeID());
        stm.setInt(3, fb.getUserID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(fb.getFeedbackDate()));
        stm.executeUpdate();
        con.close();
    }

    public void removeCmts(int feedBackID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(DELETE);
        stm.setInt(1, feedBackID);
        int count = stm.executeUpdate();
        con.close();
    }

    public int getTotalComments() throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(TOTAL_COMMENT);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            result += rs.getInt("totalC");
        }
        return result;
    }

    public void addCommentsFAdmin(int feedBackID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(ADDCOMMENTS_AD);
        stm.setInt(1, feedBackID);
        int count = stm.executeUpdate();
        con.close();
    }

    //Admin method
    public boolean Delete(int feedbackID) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setInt(1, feedbackID);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean Update(FeedBackDTO updatefeedback) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, updatefeedback.getContent());
                ptm.setInt(2, updatefeedback.getRecipeID());
                ptm.setInt(3, updatefeedback.getUserID());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ptm.setString(4, sdf.format(updatefeedback.getFeedbackDate()));
                ptm.setBoolean(5, updatefeedback.isStatus());
                ptm.setInt(6, updatefeedback.getFeedBackID());
                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }
    
    public List<FeedBackDTO> getRecentFeedbacks() throws SQLException, ClassNotFoundException {
        List<FeedBackDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(RECENT_FEEDBACKS);
            rs = ptm.executeQuery();
            while(rs.next()) {
                int feedBackID = rs.getInt("feedBackID");
                String content = rs.getString("content");
                int recipeID = rs.getInt("recipeID");
                int userID = rs.getInt("userID");
                Date feedBackDate = rs.getDate("feedBackDate");
                boolean status = rs.getBoolean("status");
                String recipeName = rs.getString("recipeName");
                String userName = rs.getString("userName");
                list.add(new FeedBackDTO(feedBackID, content, recipeID, userID, feedBackDate, status, recipeName, userName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                rs.close();
            }
            if (ptm !=null) {
                ptm.close();
            }
            if(conn !=null) {
                conn.close();
            }
        }
        return list;
    }
//    public List<FeedBackDTO> getAllFeedback() throws SQLException, ClassNotFoundException {
//        List<FeedBackDTO> list = null;
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("select * from FeedBack a "
//                + "join Recipe b on a.recipeID = b.recipeID "
//                + "join [User] c on b.userID = c.userID "
//                + "where a.[status] = 0");
//
//        ResultSet rs = stm.executeQuery();
//        list = new ArrayList<>();
//        while (rs.next()) {
//            FeedBackDTO feedback = new FeedBackDTO();
//            feedback.setFeedBackID(rs.getInt("feedBackID"));
//            feedback.setContent(rs.getString("content"));
//            feedback.setUserID(rs.getInt("userID"));
//            
//            feedback.setFeedbackDate(rs.getDate("feedbackDate"));
//            feedback.setRecipeID(rs.getInt("recipeID"));
//            feedback.setStatus(rs.getBoolean("status"));
//            list.add(feedback);
//        }
//        con.close();
//        return list;
//    }
//
//    public List<FeedBackDTO> getComments(int recipeID) throws SQLException, ClassNotFoundException {
//        List<FeedBackDTO> list = null;
//       Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("select * from FeedBack a "
//                + "join Recipe b on a.recipeID = b.recipeID "
//                + "join [User] c on a.userID = c.userID "
//                + "where a.recipeID = ? and a.[status] = 1");
//        stm.setInt(1, recipeID);
//        ResultSet rs = stm.executeQuery();
//        list = new ArrayList<>();
//        while (rs.next()) {
//            FeedBackDTO feedback = new FeedBackDTO();
//            feedback.setFeedBackID(rs.getInt("feedBackID"));
//            feedback.setContent(rs.getString("content"));
//            feedback.setUserID(rs.getInt("userID"));
//            feedback.setUserName(rs.getString("userName"));
//            feedback.setFeedbackDate(rs.getDate("feedbackDate"));
//            feedback.setRecipeID(rs.getInt("recipeID"));
//            feedback.setStatus(rs.getBoolean("status"));
//            list.add(feedback);
//        }
//        con.close();
//        return list;
//    }
//
//    public FeedBackDTO getOne(int feedBackID) throws SQLException, ClassNotFoundException {
//        FeedBackDTO feedback = null;
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("select * from [FeedBack] where feedBackID = ?");
//        ResultSet rs = stm.executeQuery();
//        if (rs.next()) {
//            feedback = new FeedBackDTO();
//            feedback.setFeedBackID(rs.getInt("feedBackID"));
//            feedback.setContent(rs.getString("content"));
//            feedback.setUserID(rs.getInt("userID"));
//            feedback.setFeedbackDate(rs.getDate("feedbackDate"));
//            feedback.setRecipeID(rs.getInt("recipeID"));
//            feedback.setStatus(rs.getBoolean("status"));
//        }
//        con.close();
//        return feedback;
//    }
//    
//    public void addComments(FeedBackDTO fb) throws SQLException, ClassNotFoundException {
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("insert [FeedBack] values(?, ?, ?, ?, 0)");
//        stm.setString(1, fb.getContent());
//        stm.setInt(2, fb.getRecipeID());
//        stm.setInt(3, fb.getUserID());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        stm.setString(4, sdf.format(fb.getFeedbackDate()));
//        stm.executeUpdate();
//        con.close();
//    }
//    
//    public void removeCmts(int feedBackID) throws SQLException, ClassNotFoundException {
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("delete [FeedBack] where feedBackID = ?");
//        stm.setInt(1, feedBackID);
//        int count = stm.executeUpdate();
//        con.close();
//    }
//
//    public int getTotalComments() throws SQLException, ClassNotFoundException {
//        int result = 0;
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("select count(feedBackID) as totalC from [feedBack]");
//        ResultSet rs = stm.executeQuery();
//        if (rs.next()) {
//            result += rs.getInt("totalC");
//        }
//        return result;
//    }
//    
//    public void addCommentsFAdmin(int feedBackID) throws SQLException, ClassNotFoundException {
//        Connection con = DBUtil.getConnection();
//        PreparedStatement stm = con.prepareStatement("update feedBack set [status] = 1 where feedBackID = ?");
//        stm.setInt(1, feedBackID);
//        int count = stm.executeUpdate();
//        con.close();
//    }
}
