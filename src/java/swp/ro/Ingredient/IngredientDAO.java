/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Ingredient;

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
public class IngredientDAO {

    private static final String INSERT_INGREDIENT = "INSERT INTO Ingredient (recipeID,ingredientName,quantity,unit) Values(?,?,?,?)";
    private static final String GET_INGREDIENT_BY_RECIPEID = "SELECT * FROM [Ingredient] WHERE recipeID = ?";
    private static final String GET_INGREDIENT = "SELECT * FROM [Ingredient]";
    private static final String ADD_INGREDIENT = "INSERT INTO [Ingredient] VALUES (?,?,?,?)";
    private static final String UPDATE_INGREDIENT_BY_RECIPEID = "UPDATE [Ingredient] SET ingredientName = ?, quantity = ?, unit = ? WHERE recipeID = ? and ingredientID = ?";

    public List<IngredientDTO> getIngredientByRecipeID(int recipeID) throws SQLException {
        List<IngredientDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_INGREDIENT_BY_RECIPEID);
                ptm.setInt(1, recipeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int ingredientID = rs.getInt("ingredientID");
                    String ingredientName = rs.getString("ingredientName");
                    double quantity = rs.getDouble("quantity");
                    String unit = rs.getString("unit");
                    list.add(new IngredientDTO(ingredientID, ingredientName, recipeID, quantity, unit));
                }
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

    public List<IngredientDTO> getAllIngredient() throws SQLException, ClassNotFoundException {
        List<IngredientDTO> list = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(GET_INGREDIENT);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            IngredientDTO ingredient = new IngredientDTO();
            ingredient.setIngredientID(rs.getInt("ingredientID"));
            ingredient.setIngredientName(rs.getString("ingredientName"));
            ingredient.setRecipeID(rs.getInt("recipeID"));
            ingredient.setQuantity(rs.getDouble("quantity"));
            ingredient.setUnit(rs.getString("unit"));
            list.add(ingredient);
        }
        con.close();
        return list;
    }

    public boolean createIngredient(IngredientDTO ingredient) throws SQLException {
        boolean check = true;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                stm = con.prepareStatement(ADD_INGREDIENT);
                stm.setString(1, ingredient.getIngredientName());
                stm.setInt(2, ingredient.getRecipeID());
                stm.setDouble(3, ingredient.getQuantity());
                stm.setString(4, ingredient.getUnit());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean insertIngredient(IngredientDTO idto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {

                ptm = con.prepareStatement(INSERT_INGREDIENT);
                int recipeID = idto.getRecipeID();
                String ingredientName = idto.getIngredientName();
                double quantity = idto.getQuantity();
                String unit = idto.getUnit();
                ptm.setInt(1, idto.getRecipeID());
                ptm.setString(2, idto.getIngredientName());
                ptm.setDouble(3, idto.getQuantity());
                ptm.setString(4, idto.getUnit());
                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public List<IngredientDTO> getIngreORecipe(int recipeID) throws SQLException, ClassNotFoundException {
        List<IngredientDTO> listIngre = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Ingredient where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        listIngre = new ArrayList<>();
        while (rs.next()) {
            IngredientDTO ingredient = new IngredientDTO();
            ingredient.setIngredientID(rs.getInt("ingredientID"));
            ingredient.setIngredientName(rs.getString("ingredientName"));
            ingredient.setRecipeID(rs.getInt("recipeID"));
            ingredient.setQuantity(rs.getDouble("quantity"));
            ingredient.setUnit(rs.getString("unit"));
            listIngre.add(ingredient);
        }
        con.close();
        return listIngre;
    }

    public boolean updateIngredient(IngredientDTO updateIngredient) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_INGREDIENT_BY_RECIPEID);
                ptm.setString(1, updateIngredient.getIngredientName());
                ptm.setDouble(2, updateIngredient.getQuantity());
                ptm.setString(3, updateIngredient.getUnit());
                ptm.setInt(4, updateIngredient.getRecipeID());
                ptm.setInt(5, updateIngredient.getIngredientID());
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

}
