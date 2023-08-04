/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.savedRecipes;

/**
 *
 * @author truc0
 */
public class SavedRecipesDTO {
    private int savedRecipeID;
    private int recipeID;
    private int userID;
    private String img;
    private String recipeName;
    public SavedRecipesDTO() {
    }

    public SavedRecipesDTO(int savedRecipeID, int recipeID, int userID, String img, String recipeName) {
        this.savedRecipeID = savedRecipeID;
        this.recipeID = recipeID;
        this.userID = userID;
        this.img = img;
        this.recipeName = recipeName;
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

  

    public int getSavedRecipeID() {
        return savedRecipeID;
    }

    public void setSavedRecipeID(int savedRecipeID) {
        this.savedRecipeID = savedRecipeID;
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
        return "SavedRecipesDTO{" + "savedRecipeID=" + savedRecipeID + ", recipeID=" + recipeID + ", userID=" + userID + '}';
    }
    
}
