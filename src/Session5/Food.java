package Session5;

import java.util.ArrayList;

public class Food {
    private int id;
    private String name;
    private boolean sugar;
    private boolean hot;
    private double sellingPrice;
    private double productionCost;
    private ArrayList<Ingredient> ingredients;

    public Food(String name, boolean sugar, boolean hot) {
        this.name = name;
        this.sugar = sugar;
        this.hot = hot;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double calculateProductionCost() {
        double totalCost = 0;
        int percentage = hot ? 120 : 110;

        for (Ingredient ingredient : ingredients) {
            totalCost += ingredient.getPrice();
        }

        totalCost = totalCost * percentage / 100;

        if (sugar)
            totalCost += 400;

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
}
