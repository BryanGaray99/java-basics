package Session5;

public class Ingredient {
    private int id;
    private String name;
    private double calories;
    private double price;
    private double amount;

    public Ingredient(String name, double calories, double price, double amount) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
