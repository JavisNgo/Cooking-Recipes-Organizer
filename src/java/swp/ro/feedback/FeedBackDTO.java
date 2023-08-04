/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.feedback;

import java.util.Date;






/**
 *
 * @author truc0
 */
public class FeedBackDTO {
    private int feedBackID;
    private String content;
    private int recipeID;
    private int userID;
    private Date feedbackDate;
    private boolean status;
    private String recipeName;
    private String userName;

    public FeedBackDTO() {
    }

    public FeedBackDTO(int feedBackID, String content, int recipeID, int userID, Date feedbackDate, boolean status, String recipeName, String userName) {
        this.feedBackID = feedBackID;
        this.content = content;
        this.recipeID = recipeID;
        this.userID = userID;
        this.feedbackDate = feedbackDate;
        this.status = status;
        this.recipeName = recipeName;
        this.userName = userName;
    }

    public int getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(int feedBackID) {
        this.feedBackID = feedBackID;
    }

   
     public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
