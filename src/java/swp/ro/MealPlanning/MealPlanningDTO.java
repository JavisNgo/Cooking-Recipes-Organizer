/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.MealPlanning;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author truc0
 */
public class MealPlanningDTO {
    private int planningID;
    private int userID;
    private int savedRecipeID;
    private String recipeName;
    private String date;

    public MealPlanningDTO() {
    }

    public MealPlanningDTO(int planningID, int userID, int savedRecipeID, String recipeName, String date) {
        this.planningID = planningID;
        this.userID = userID;
        this.savedRecipeID = savedRecipeID;
        this.recipeName = recipeName;
        this.date = date;
    }

   
   
    public int getPlanningID() {
        return planningID;
    }

    public void setPlanningID(int planningID) {
        this.planningID = planningID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSavedRecipeID() {
        return savedRecipeID;
    }

    public void setSavedRecipeID(int savedRecipeID) {
        this.savedRecipeID = savedRecipeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

   

    
    @Override
    public String toString() {
        return "MealPlanningDTO{" + "planningID=" + planningID + ", userID=" + userID + ", savedRecipeID=" + savedRecipeID +", recipeName="+recipeName+ ", date=" + date + '}';
    }
    
}
