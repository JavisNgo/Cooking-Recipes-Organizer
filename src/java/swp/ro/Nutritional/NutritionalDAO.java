/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Nutritional;

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
public class NutritionalDAO {
    
    private static final String GET_ALL = "SELECT * FROM Nutritional order by [name] asc";
    private static final String GET_BY_INGREDIENT_NAME = "SELECT * FROM Nutritional WHERE ingredientName = ?";

    public List<NutritionalDTO> getAllNutritional() throws SQLException {
        List<NutritionalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(GET_ALL);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int nutritionalID = rs.getInt("nutritionalID");
                String ingredientName = rs.getString("name");
                double calories = rs.getDouble("calories");
                double fat = rs.getDouble("fat");
                double proteins = rs.getDouble("proteins");
                double carb = rs.getDouble("carb");
                double sugar = rs.getDouble("sugar");
                list.add(new NutritionalDTO(nutritionalID, ingredientName, calories, fat, proteins, carb, sugar));
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
        return list;
    }
    
    public NutritionalDTO getByIngredientName(String ingredientName) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        NutritionalDTO nutritional = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareStatement(GET_BY_INGREDIENT_NAME);
            ptm.setString(1, ingredientName);
            rs = ptm.executeQuery();
            if(rs.next()) {
                int nutritionalID = rs.getInt("nutritionalID");
                float calories = rs.getFloat("calories");
                float fat = rs.getFloat("fat");
                float proteins = rs.getFloat("proteins");
                float carb = rs.getFloat("carb");
                float sugar = rs.getFloat("sugar");
                nutritional = new NutritionalDTO(nutritionalID, ingredientName, calories, fat, proteins, carb, sugar);
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
        return nutritional;
    }
    
    public NutritionalDTO getNutriOneRecipe(int recipeID) throws SQLException, ClassNotFoundException {
        NutritionalDTO nutritional = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select sum(calories) as calories,"
                + " SUM(fat) as fat, SUM(carb) as carb,"
                + " SUM(proteins) as proteins, SUM(sugar) as sugar "
                + "from Nutritional a join Ingredient b "
                + "on a.[name] = b.ingredientName where b.recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            nutritional = new NutritionalDTO();
            nutritional.setCalories(rs.getDouble("calories"));
            nutritional.setFat(rs.getDouble("fat"));
            nutritional.setCarb(rs.getDouble("carb"));
            nutritional.setProteins(rs.getDouble("proteins"));
            nutritional.setSugar(rs.getDouble("sugar"));
        }
        con.close();
        return nutritional;
    }
    
    
}
