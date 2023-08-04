/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.IngredientOfRecipe;

/**
 *
 * @author truc0
 */
public class IngredientOfRecipeDTO {
    private int ID;
    private int recipeID;
    private int ingredientID; 
    private double measurement;

    public IngredientOfRecipeDTO() {
    }

    public IngredientOfRecipeDTO(int ID, int recipeID, int ingredientID, double measurement) {
        this.ID = ID;
        this.recipeID = recipeID;
        this.ingredientID = ingredientID;
        this.measurement = measurement;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" + "ID=" + ID + ", recipeID=" + recipeID + ", ingredientID=" + ingredientID + ", measurement=" + measurement + '}';
    }
    
}
