package swp.ro.rating;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author truc0
 */
public class RatingDTO {

    private int rateID;
    private int userID;
    private int recipeID;
    private int scoreUser;
    private String recipeName;

    public RatingDTO() {
    }

    public RatingDTO(int rateID, int userID, int recipeID, int scoreUser) {
        this.rateID = rateID;
        this.userID = userID;
        this.recipeID = recipeID;
        this.scoreUser = scoreUser;
    }

    public RatingDTO(int rateID, int userID, int recipeID, int scoreUser, String recipeName) {
        this.rateID = rateID;
        this.userID = userID;
        this.recipeID = recipeID;
        this.scoreUser = scoreUser;
        this.recipeName = recipeName;
    }

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getScoreUser() {
        return scoreUser;
    }

    public void setScoreUser(int scoreUser) {
        this.scoreUser = scoreUser;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    @Override
    public String toString() {
        return "RatingDTO{" + "rateID=" + rateID + ", userID=" + userID + ", recipeID=" + recipeID + ", scoreUser=" + scoreUser + '}';
    }

}
