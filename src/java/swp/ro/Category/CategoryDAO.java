package swp.ro.Category;

import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import swp.ro.Recipe.RecipeDTO;

public class CategoryDAO {

    private static final String SHOWALL = "SELECT * FROM [Category]";
    private static final String SEARCHBYCATEGORY = "SELECT categoryID FROM [Category] WHERE categoryName = ?";

    public List<CategoryDTO> getListCategories() throws SQLException, ClassNotFoundException {
        List<CategoryDTO> listcategories = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement(SHOWALL);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            CategoryDTO cate = new CategoryDTO();
            cate.setCategoryID(rs.getInt("categoryID"));
            cate.setCategoryName(rs.getString("categoryName"));
            cate.setImageCate(rs.getString("imageCate"));
            listcategories.add(cate);
        }
        con.close();
        return listcategories;
    }

    public CategoryDTO getCategory(String categoryName) throws SQLException {
        CategoryDTO category = new CategoryDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ptm = conn.prepareCall(SEARCHBYCATEGORY);
            ptm.setString(1, categoryName);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("categoryID");
                String imageCate = rs.getString("imageString");
                category.setCategoryID(categoryID);
                category.setImageCate(imageCate);
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
        return category;
    }

    public List<RecipeDTO> getCategoriesFromFilter(String categoryName) throws SQLException, ClassNotFoundException {
        List<RecipeDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Recipe a "
                + "join [CategoryOfRecipes] b on a.recipeID = b.recipeID "
                + "join [User] d on a.userID = d.userID "
                + "join Category c on b.categoryID = c.categoryID "
                + "where c.categoryName = ?");
        stm.setString(1, categoryName);
        list = new ArrayList<>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            RecipeDTO recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setUserName(rs.getString("userName"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setImage(rs.getString("image"));
            recipe.setStatus(rs.getBoolean("status"));
            list.add(recipe);
        }
        con.close();
        return list;
    }

    public List<RecipeDTO> getBothFromFilter(String meal, String categoryName) throws SQLException, ClassNotFoundException {
        List<RecipeDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Recipe a join [User] b on a.userID = b.userID \n"
                + "join CategoryOfRecipes c on a.recipeID = c.recipeID \n"
                + "join Category d on c.categoryID = d.categoryID \n"
                + "where a.meal like ? and d.categoryName = ? ");
        stm.setString(1, "%" + meal + "%");
        stm.setString(2, categoryName);
        list = new ArrayList<>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            RecipeDTO recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setUserName(rs.getString("userName"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setImage(rs.getString("image"));
            recipe.setStatus(rs.getBoolean("status"));
            list.add(recipe);
        }
        con.close();
        return list;
    }

    public List<RecipeDTO> getCategoriesFromFilter1(String[] categories) throws SQLException, ClassNotFoundException {
        List<RecipeDTO> list = null;
        Connection con = DBUtil.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Recipe a "
                + "join [CategoryOfRecipes] b on a.recipeID = b.recipeID "
                + "join [User] d on a.userID = d.userID "
                + "join Category c on b.categoryID = c.categoryID "
                + "where c.categoryName = ?");
        for (String categorie : categories) {
            stm.setString(1, categorie);
            list = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                RecipeDTO recipe = new RecipeDTO();
                recipe.setRecipeID(rs.getInt("recipeID"));
                recipe.setUserID(rs.getInt("userID"));
                recipe.setRecipeName(rs.getString("recipeName"));
                recipe.setDatePost(rs.getDate("datePost"));
                recipe.setUserName(rs.getString("userName"));
                recipe.setDescription(rs.getString("description"));
                recipe.setCookingTime(rs.getDouble("cookingTime"));
                recipe.setImage(rs.getString("image"));
                recipe.setStatus(rs.getBoolean("status"));
                list.add(recipe);
            }
        }
        
        con.close();
        return list;
    }
}
