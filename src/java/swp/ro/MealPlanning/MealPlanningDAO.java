/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.MealPlanning;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import swp.ro.savedRecipes.SavedRecipesDTO;

/**
 *
 * @author truc0
 */
public class MealPlanningDAO {

    private static final String INSERT = "INSERT INTO [MealPlanning] VALUES(?,?,?)";

    public void insert(MealPlanningDTO pl) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO MealPlanning(userID,savedRecipeID,date) VALUES (?,?,?)");
        stm.setInt(1, pl.getUserID());
        stm.setInt(2, pl.getSavedRecipeID());
        stm.setString(3, pl.getDate());
        stm.executeUpdate();
    }

    public MealPlanningDTO getOne(int userID, int savedRecipeID, String date) throws SQLException, ClassNotFoundException {
        MealPlanningDTO mp = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from MealPlanning where userID = ? and savedRecipeID = ? and date = ?");
        stm.setInt(1, userID);
        stm.setInt(2, savedRecipeID);
        stm.setString(3, date);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            mp = new MealPlanningDTO();
            mp.setPlanningID(rs.getInt("planningID"));
            mp.setUserID(rs.getInt("userID"));
            mp.setSavedRecipeID(rs.getInt("savedRecipeID"));
            mp.setDate(rs.getString("date"));
        }
        con.close();
        return mp;
    }

    public List<MealPlanningDTO> getPlanning(int userID, String date) throws SQLException, ClassNotFoundException {
        List<MealPlanningDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from MealPlanning a join [Recipe] b on a.savedRecipeID = b.recipeID \n"
                + "                 join [User] c on b.userID = c.userID where a.userID = ? and a.date='?'");
        stm.setInt(1, userID);
        stm.setString(2, date);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
         while (rs.next()) {
             MealPlanningDTO planning=new MealPlanningDTO();
             SavedRecipesDTO save=new SavedRecipesDTO();
             planning.setSavedRecipeID(rs.getInt("savedRecipeID"));
             planning.setRecipeName(rs.getString("recipeName"));
             planning.setUserID(rs.getInt("userID"));
             planning.setPlanningID(rs.getInt("planningID"));
             planning.setDate(rs.getString("date"));
             list.add(planning);
         }
        return list;
    }
     public void removePlanRecipe(int userID,int savedRecipeID,String date) throws SQLException, ClassNotFoundException {
          Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("DELETE MealPlanning WHERE userID=? and savedrecipeID=? and date=?");
        stm.setInt(1, userID);
        stm.setInt(2, savedRecipeID);
        stm.setString(3, date);
        stm.executeUpdate();
        con.close();
    }
    
}
