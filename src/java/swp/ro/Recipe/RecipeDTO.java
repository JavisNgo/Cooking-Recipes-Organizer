/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Recipe;

import java.util.Date;

/**
 *
 * @author truc0
 */
public class RecipeDTO {

    private int recipeID;
    private int userID;
    private String recipeName;
    private Date datePost;
    private String description;
    private double cookingTime;
    private String image;
    private boolean status;
    private String meal;
    private String userName;

    public RecipeDTO() {
    }

    public RecipeDTO(int recipeID, int userID, String recipeName, Date datePost, String description, double cookingTime, String image, boolean status, String meal, String userName) {
        this.recipeID = recipeID;
        this.userID = userID;
        this.recipeName = recipeName;
        this.datePost = datePost;
        this.description = description;
        this.cookingTime = cookingTime;
        this.image = image;
        this.status = status;
        this.meal = meal;
        this.userName = userName;
    }

    public RecipeDTO(int recipeID, int userID, String recipeName, Date datePost, String description, double cookingTime, String image, String meal, boolean status) {
        this.recipeID = recipeID;
        this.userID = userID;
        this.recipeName = recipeName;
        this.datePost = datePost;
        this.description = description;
        this.cookingTime = cookingTime;
        this.image = image;
        this.status = status;
        this.meal = meal;
    }

    public RecipeDTO(int userID, String recipeName, Date datePost, String description, double cookingTime, String image, String meal, boolean status) {
        this.userID = userID;
        this.recipeName = recipeName;
        this.datePost = datePost;
        this.description = description;
        this.cookingTime = cookingTime;
        this.image = image;
        this.status = status;
        this.meal = meal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
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

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
