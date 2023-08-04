/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swp.ro.Nutritional;

/**
 *
 * @author truc0
 */
public class NutritionalDTO {
    private int nutritionalID;
    private String name;
    private double calories;
    private double fat;
    private double proteins;
    private double carb;
    private double sugar;

    public NutritionalDTO() {
    }

    public NutritionalDTO(int nutritionalID, String name, double calories, double fat, double proteins, double carb, double sugar) {
        this.nutritionalID = nutritionalID;
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.proteins = proteins;
        this.carb = carb;
        this.sugar = sugar;
    }

    public int getNutritionalID() {
        return nutritionalID;
    }

    public void setNutritionalID(int nutritionalID) {
        this.nutritionalID = nutritionalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
    
    
}
