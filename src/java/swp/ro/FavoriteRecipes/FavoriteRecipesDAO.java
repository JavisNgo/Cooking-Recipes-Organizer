/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.FavoriteRecipes;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swp.ro.Recipe.RecipeDTO;
import swp.ro.User.UserDTO;

/**
 *
 * @author truc0
 */
public class FavoriteRecipesDAO {
    private static final String SEARCH = "select count(*) AS totalCount from FavoriteRecipes fr where recipeID=? AND [STATUS]=1";
    private static final String COMMENT_COUNT = "SELECT COUNT(*) AS totalComments FROM FavoriteRecipes WHERE recipeID=?";
    private static final String COUNT_COMMENT = "SELECT COUNT(*) AS totalComment FROM feedback WHERE recipeID=? AND [STATUS]=1";

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
    
    public Map<Integer, Integer> getListLike(List<RecipeDTO> list) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        Map<Integer, Integer> map = new HashMap<>();
        int totalComments = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                for (RecipeDTO recipe : list) {
//                    ptm = conn.prepareStatement(SEARCH);
//                    ptm.setInt(1, recipe.getRecipeID());
//                    rs = ptm.executeQuery();
//                    if(rs!=null){
//                        int count = rs.getInt("totalCount");
//                        map.put(recipe.getRecipeID(), count);
//                    }
                    ptm = conn.prepareStatement(COMMENT_COUNT);
                    ptm.setInt(1, recipe.getRecipeID());
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                    totalComments = rs.getInt("totalComments");
                    map.put(recipe.getRecipeID(), totalComments);
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
    public int getTotalCommentsForRecipe(int recipeID) throws SQLException, ClassNotFoundException {
        int totalComments = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            // Kết nối đến cơ sở dữ liệu (DBUtil.makeConnection() là phương thức giả định)
            conn = DBUtil.getConnection();

            if (conn != null) {
                // Chuẩn bị truy vấn SQL
                ptm = conn.prepareStatement(COMMENT_COUNT);
                ptm.setInt(1, recipeID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    totalComments = rs.getInt("totalComments");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần thiết
        } finally {
            // Đóng tất cả các tài nguyên sau khi sử dụng
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

        return totalComments;
    }
    
    public int totalFavoriteORecipe(int recipeID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select count(*) from FavoriteRecipes where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
     public void addFavoriteByID(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("insert FavoriteRecipes values(?,?)");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        stm.executeUpdate();
        con.close();
    }

    public void removeFavoriteRecipe(int userID,int recipeID) throws SQLException, ClassNotFoundException {
         Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("delete FavoriteRecipes where userID= ? and recipeID = ?");
        stm.setInt(1, userID);
        stm.setInt(2, recipeID);
        stm.executeUpdate();
        con.close();
    }
    public FavoriteRecipesDTO getFavoriteRecipeID(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        FavoriteRecipesDTO favorite = null;
         Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes a join Recipe b "
                + "on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.recipeID = ? and a.userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            favorite = new FavoriteRecipesDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setRecipeName(rs.getString("recipeName"));
            favorite.setUserID(rs.getInt("userID"));
        }
        con.close();
        return favorite;
    }
    public FavoriteRecipesDTO getOneFavorite(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        FavoriteRecipesDTO favorite = null;
         Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes where recipeID = ? and userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            favorite = new FavoriteRecipesDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setUserID(rs.getInt("userID"));
        }
        con.close();
        return favorite;
    }
    public List<FavoriteRecipesDTO> getFavorite(int userID) throws SQLException, ClassNotFoundException {
        List<FavoriteRecipesDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes a join [Recipe] b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID where a.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FavoriteRecipesDTO favorite = new FavoriteRecipesDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setImg(rs.getString("image"));
            favorite.setRecipeName(rs.getString("recipeName"));
            favorite.setUserID(rs.getInt("userID"));
            list.add(favorite);
        }
        con.close();
        return list;
    }
  
}
