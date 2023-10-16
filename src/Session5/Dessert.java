package Session5;

import java.util.ArrayList;

public class Dessert {
    private int id;
    private String name;
    private boolean hot;
    private double sellingPrice;
    private double productionCost;
    private double calories;
    private ArrayList<Ingredient> ingredients;

    public Dessert(String name, boolean hot, double calories) {
        this.name = name;
        this.hot = hot;
        this.calories = calories;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double calculateProductionCost() {
        double totalCost = 0;
        int percentage = hot ? 120 : 112;

        for (Ingredient ingredient : ingredients) {
            totalCost += ingredient.getPrice();
        }

        totalCost = totalCost * percentage / 100;

        this.productionCost = totalCost;
        return this.productionCost;
    }

    public double calculateSellingPrice() {
        this.sellingPrice = calculateProductionCost() + 1000;
        return this.sellingPrice;
    }

    public String getName() {
        return name;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
