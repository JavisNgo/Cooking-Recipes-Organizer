/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Step;

/**
 *
 * @author My PC
 */
public class StepDTO {

    private int stepID;
    private int recipeID;
    private String stepNumber;
    private String instructions;

    public StepDTO() {
    }

    public StepDTO(int stepID, int recipeID, String stepNumber, String instructions) {
        this.stepID = stepID;
        this.recipeID = recipeID;
        this.stepNumber = stepNumber;
        this.instructions = instructions;
    }

    public StepDTO(int recipeID, String stepNumber, String instructions) {
        this.recipeID = recipeID;
        this.stepNumber = stepNumber;
        this.instructions = instructions;
    }

    public int getStepID() {
        return stepID;
    }

    public void setStepID(int stepID) {
        this.stepID = stepID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public String getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(String stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "StepDTO{" + "stepID=" + stepID + ", recipeID=" + recipeID + ", stepNumber=" + stepNumber + ", instructions=" + instructions + '}';
    }

}
