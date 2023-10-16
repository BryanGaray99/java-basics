package Session5;

import java.util.ArrayList;

public class Drink {
    private int id;
    private String name;
    private String type;
    private double sellingPrice;
    private double productionCost;
    private ArrayList<Ingredient> ingredients;

    public Drink(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double calculateProductionCost() {
        double totalCost = 0;
        int percentage = 0;

        switch (type) {
            case "milkshake":
                percentage = 115;
                break;
            case "juice":
                percentage = 110;
                break;
            case "alcohol":
                percentage = 100;
                totalCost += 400;
                break;
        }

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
}
