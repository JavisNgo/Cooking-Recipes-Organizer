/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.savedRecipes;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truc0
 */
public class SavedRecipesDAO {
    
    public void addSavedByID(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
          
        PreparedStatement stm = con.prepareStatement("insert SavedRecipes values(?,?)");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        stm.executeUpdate();
        con.close();
    }

    public void removeSavedRecipe(int userID,int recipeID) throws SQLException, ClassNotFoundException {
          Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("delete SavedRecipes where userID= ? and recipeID = ?");
        stm.setInt(1, userID);
        stm.setInt(2, recipeID);
        stm.executeUpdate();
        con.close();
    }
    
    public int totalSavedORecipe(int recipeID) throws SQLException, ClassNotFoundException {
         Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select count(*) from SavedRecipes where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    
    public SavedRecipesDTO getOneSaved(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        SavedRecipesDTO save = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes where recipeID = ? and userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            save = new SavedRecipesDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setUserID(rs.getInt("userID"));
        }
        con.close();
        return save;
    }
    public SavedRecipesDTO getSavedRecipeID(int recipeID, int userID) throws SQLException, ClassNotFoundException {
        SavedRecipesDTO save = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes a join Recipe b "
                + "on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.recipeID = ? and a.userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            save = new SavedRecipesDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setRecipeName(rs.getString("recipeName"));
            save.setImg(rs.getString("image"));
            save.setUserID(rs.getInt("userID"));
        }
        con.close();
        return save;
    }
    public List<SavedRecipesDTO> getSaved(int userID) throws SQLException, ClassNotFoundException {
        List<SavedRecipesDTO> list = null;
          Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes a join [Recipe] b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID where a.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            SavedRecipesDTO save = new SavedRecipesDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setImg(rs.getString("image"));
            save.setRecipeName(rs.getString("recipeName"));
            save.setUserID(rs.getInt("userID"));
            list.add(save);
        }
        con.close();
        return list;
    }
}
