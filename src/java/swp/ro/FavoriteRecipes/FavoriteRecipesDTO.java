/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.FavoriteRecipes;

/**
 *
 * @author truc0
 */
public class FavoriteRecipesDTO {
    private int favoriteRecipeID;
    private int recipeID;
    private int userID;
    private String img;
    private String recipeName;
    public FavoriteRecipesDTO() {
    }
    
    public FavoriteRecipesDTO(int favoriteRecipeID, int recipeID, int userID) {
        this.favoriteRecipeID = favoriteRecipeID;
        this.recipeID = recipeID;
        this.userID = userID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    

    public int getFavoriteRecipeID() {
        return favoriteRecipeID;
    }

    public void setFavoriteRecipeID(int favoriteRecipeID) {
        this.favoriteRecipeID = favoriteRecipeID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "FavoriteRecipesDTO{" + "favoriteRecipeID=" + favoriteRecipeID + ", recipeID=" + recipeID + ", userID=" + userID + '}';
    }
    
}
