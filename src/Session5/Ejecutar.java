package Session5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutar {
    private static ArrayList<Ingredient> ingredientInventory = new ArrayList<>();
    private static ArrayList<Food> foodInventory = new ArrayList<>();
    private static ArrayList<Drink> drinkInventory = new ArrayList<>();
    private static ArrayList<Dessert> dessertInventory = new ArrayList<>();
    private static double currentMoney = 100000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ingredient arroz = new Ingredient("Arroz", 100, 150, 500);
        Ingredient platano = new Ingredient("Plátano", 150, 200, 300);
        Ingredient camaron = new Ingredient("Camarón", 200, 500, 200);
        Ingredient leche = new Ingredient("Leche", 70, 100, 1000);
        Ingredient tomate = new Ingredient("Tomate", 60, 300, 300);
        Ingredient azucar = new Ingredient("Azucar", 40, 205, 400);

        // Agrega los ingredientes a la lista de inventario de ingredientes
        ingredientInventory.add(arroz);
        ingredientInventory.add(platano);
        ingredientInventory.add(camaron);
        ingredientInventory.add(leche);
        ingredientInventory.add(tomate);
        ingredientInventory.add(azucar);

        // Inicializa platos típicos en Ecuador
        Food ceviche = new Food("Ceviche", false, false);
        Food encebollado = new Food("Encebollado", false, true);
        Dessert tresLeches = new Dessert("Tres Leches", false, 300);
        Dessert helado = new Dessert("Helado", false, 200);
        Drink jugoMora = new Drink("Jugo de Mora", "juice");
        Drink coladaMorada = new Drink("Colada Morada", "juice");

        // Asigna ingredientes a los platos
        ArrayList<Ingredient> ingredientsCeviche = new ArrayList<>();
        ingredientsCeviche.add(camaron);
        ingredientsCeviche.add(tomate);
        ceviche.setIngredients(ingredientsCeviche);

        ArrayList<Ingredient> ingredientsEncebollado = new ArrayList<>();
        ingredientsEncebollado.add(arroz);
        ingredientsEncebollado.add(tomate);
        encebollado.setIngredients(ingredientsEncebollado);

        ArrayList<Ingredient> ingredientsTresLeches = new ArrayList<>();
        ingredientsTresLeches.add(leche);
        ingredientsTresLeches.add(azucar);
        tresLeches.setIngredients(ingredientsTresLeches);

        ArrayList<Ingredient> ingredientsHelado = new ArrayList<>();
        ingredientsHelado.add(leche);
        ingredientsHelado.add(azucar);
        helado.setIngredients(ingredientsHelado);

        ArrayList<Ingredient> ingredientsJugoMora = new ArrayList<>();
        ingredientsJugoMora.add(azucar);
        jugoMora.setIngredients(ingredientsJugoMora);

        ArrayList<Ingredient> ingredientsColadaMorada = new ArrayList<>();
        ingredientsColadaMorada.add(azucar);
        coladaMorada.setIngredients(ingredientsColadaMorada);

        // Agrega los platos a las listas de inventario de platos
        foodInventory.add(ceviche);
        foodInventory.add(encebollado);
        dessertInventory.add(tresLeches);
        dessertInventory.add(helado);
        drinkInventory.add(jugoMora);
        drinkInventory.add(coladaMorada);


        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Print my current money amount");
            System.out.println("2. Print my current ingredient inventory");
            System.out.println("3. Buy some amount of any ingredient");
            System.out.println("4. Print my dishes inventory");
            System.out.println("5. Make a dish");
            System.out.println("6. Sell a dish");
            System.out.println("0. Exit");
            System.out.print("Select an option (0-6): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    printCurrentMoney();
                    break;
                case 2:
                    printIngredientInventory();
                    break;
                case 3:
                    buyIngredients(scanner);
                    break;
                case 4:
                    printDishesInventory();
                    break;
                case 5:
                    makeDish(scanner);
                    break;
                case 6:
                    sellDish(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (option != 0);
    }

    private static void printCurrentMoney() {
        System.out.println("Dinero actual: $" + currentMoney);
    }

    private static void printIngredientInventory() {
        System.out.println("Inventario de ingredientes:");
        for (Ingredient ingredient : ingredientInventory) {
            System.out.println(ingredient.getName() + " - Cantidad: " + ingredient.getAmount());
        }
    }

    private static void buyIngredients(Scanner scanner) {
        System.out.print("Nombre del ingrediente a comprar: ");
        String ingredientName = scanner.next();
        System.out.print("Cantidad a comprar: ");
        double amountToBuy = scanner.nextDouble();
        System.out.print("Precio por unidad: ");
        double pricePerUnit = scanner.nextDouble();

        boolean ingredientExists = false;

        for (Ingredient ingredient : ingredientInventory) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                ingredient.setAmount(ingredient.getAmount() + amountToBuy);
                ingredientExists = true;
                break;
            }
        }

        if (!ingredientExists) {
            Ingredient newIngredient = new Ingredient(ingredientName, 0, pricePerUnit, amountToBuy);
            ingredientInventory.add(newIngredient);
        }

        currentMoney -= (amountToBuy * pricePerUnit);
        System.out.println("Compra realizada con éxito.");
    }

    private static void printDishesInventory() {
        System.out.println("Inventario de Platos:");

        // Imprimir platos de postre (Dessert)
        for (Dessert dessert : dessertInventory) {
            System.out.println("Nombre: " + dessert.getName() + ", Precio de venta: $" + dessert.calculateSellingPrice());
        }

        // Imprimir bebidas (Drink)
        for (Drink drink : drinkInventory) {
            System.out.println("Nombre: " + drink.getName() + ", Precio de venta: $" + drink.calculateSellingPrice());
        }

        // Imprimir comidas (Food)
        for (Food food : foodInventory) {
            System.out.println("Nombre: " + food.getName() + ", Precio de venta: $" + food.calculateSellingPrice());
        }
    }

    private static void makeDish(Scanner scanner) {
        System.out.print("Tipo de plato (Dessert, Drink, o Food): ");
        String dishType = scanner.next();

        if (dishType.equalsIgnoreCase("Dessert")) {
            makeDessert(scanner);
        } else if (dishType.equalsIgnoreCase("Drink")) {
            makeDrink(scanner);
        } else if (dishType.equalsIgnoreCase("Food")) {
            makeFood(scanner);
        } else {
            System.out.println("Tipo de plato no válido. Debe ser Dessert, Drink o Food.");
        }
    }

    private static void makeDessert(Scanner scanner) {
        System.out.print("Nombre del postre: ");
        String name = scanner.next();
        System.out.print("Es caliente (true/false): ");
        boolean isHot = scanner.nextBoolean();
        System.out.print("Calorías: ");
        double calories = scanner.nextDouble();

        Dessert dessert = new Dessert(name, isHot, calories);

        // Mostrar los ingredientes disponibles
        System.out.println("Ingredientes disponibles:");
        for (Ingredient ingredient : ingredientInventory) {
            System.out.println(ingredient.getName() + " - Cantidad: " + ingredient.getAmount());
        }

        // Pedir los ingredientes y verificar disponibilidad
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
        System.out.println("Agrega ingredientes al postre (ingresa 'fin' para terminar):");
        while (true) {
            System.out.print("Nombre del ingrediente: ");
            String ingredientName = scanner.next();

            if (ingredientName.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Cantidad requerida: ");
            double requiredAmount = scanner.nextDouble();

            // Verificar si el ingrediente existe y está disponible
            boolean ingredientExists = false;
            for (Ingredient ingredient : ingredientInventory) {
                if (ingredient.getName().equalsIgnoreCase(ingredientName) && ingredient.getAmount() >= requiredAmount) {
                    ingredientExists = true;
                    selectedIngredients.add(new Ingredient(ingredientName, ingredient.getCalories(), ingredient.getPrice(), requiredAmount));
                    ingredient.setAmount(ingredient.getAmount() - requiredAmount);
                    break;
                }
            }

            if (!ingredientExists) {
                System.out.println("Debes comprar el ingrediente o la cantidad requerida no está disponible.");
            }
        }

        // Calcular y restar el costo de producción
        double productionCost = dessert.calculateProductionCost();
        if (currentMoney >= productionCost) {
            currentMoney -= productionCost;
            dessert.setIngredients(selectedIngredients);
            dessertInventory.add(dessert);
            System.out.println("Plato de postre creado con éxito.");
        } else {
            System.out.println("No tienes suficiente dinero para crear este postre.");
        }
    }

    private static void makeDrink(Scanner scanner) {
        System.out.print("Nombre de la bebida: ");
        String name = scanner.next();
        System.out.print("Tipo de bebida (milkshake, juice, alcohol): ");
        String type = scanner.next();

        Drink drink = new Drink(name, type);

        // Mostrar los ingredientes disponibles
        System.out.println("Ingredientes disponibles:");
        for (Ingredient ingredient : ingredientInventory) {
            System.out.println(ingredient.getName() + " - Cantidad: " + ingredient.getAmount());
        }

        // Pedir los ingredientes y verificar disponibilidad
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
        System.out.println("Agrega ingredientes a la bebida (ingresa 'fin' para terminar):");
        while (true) {
            System.out.print("Nombre del ingrediente: ");
            String ingredientName = scanner.next();

            if (ingredientName.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Cantidad requerida: ");
            double requiredAmount = scanner.nextDouble();

            // Verificar si el ingrediente existe y está disponible
            boolean ingredientExists = false;
            for (Ingredient ingredient : ingredientInventory) {
                if (ingredient.getName().equalsIgnoreCase(ingredientName) && ingredient.getAmount() >= requiredAmount) {
                    ingredientExists = true;
                    selectedIngredients.add(new Ingredient(ingredientName, ingredient.getCalories(), ingredient.getPrice(), requiredAmount));
                    ingredient.setAmount(ingredient.getAmount() - requiredAmount);
                    break;
                }
            }

            if (!ingredientExists) {
                System.out.println("Debes comprar el ingrediente o la cantidad requerida no está disponible.");
            }
        }

        // Calcular y restar el costo de producción
        double productionCost = drink.calculateProductionCost();
        if (currentMoney >= productionCost) {
            currentMoney -= productionCost;
            drink.setIngredients(selectedIngredients);
            drinkInventory.add(drink);
            System.out.println("Bebida creada con éxito.");
        } else {
            System.out.println("No tienes suficiente dinero para crear esta bebida.");
        }
    }

    private static void makeFood(Scanner scanner) {
        System.out.print("Nombre de la comida: ");
        String name = scanner.next();
        System.out.print("¿Contiene azúcar? (true/false): ");
        boolean sugar = scanner.nextBoolean();
        System.out.print("¿Es caliente? (true/false): ");
        boolean hot = scanner.nextBoolean();

        Food food = new Food(name, sugar, hot);

        // Mostrar los ingredientes disponibles
        System.out.println("Ingredientes disponibles:");
        for (Ingredient ingredient : ingredientInventory) {
            System.out.println(ingredient.getName() + " - Cantidad: " + ingredient.getAmount());
        }

        // Pedir los ingredientes y verificar disponibilidad
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
        System.out.println("Agrega ingredientes a la comida (ingresa 'fin' para terminar):");
        while (true) {
            System.out.print("Nombre del ingrediente: ");
            String ingredientName = scanner.next();

            if (ingredientName.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Cantidad requerida: ");
            double requiredAmount = scanner.nextDouble();

            // Verificar si el ingrediente existe y está disponible
            boolean ingredientExists = false;
            for (Ingredient ingredient : ingredientInventory) {
                if (ingredient.getName().equalsIgnoreCase(ingredientName) && ingredient.getAmount() >= requiredAmount) {
                    ingredientExists = true;
                    selectedIngredients.add(new Ingredient(ingredientName, ingredient.getCalories(), ingredient.getPrice(), requiredAmount));
                    ingredient.setAmount(ingredient.getAmount() - requiredAmount);
                    break;
                }
            }

            if (!ingredientExists) {
                System.out.println("Debes comprar el ingrediente o la cantidad requerida no está disponible.");
            }
        }

        // Agregar los ingredientes seleccionados a la comida
        food.setIngredients(selectedIngredients);

        // Calcular y restar el costo de producción
        double productionCost = food.calculateProductionCost();
        if (currentMoney >= productionCost) {
            currentMoney -= productionCost;
            foodInventory.add(food);
            System.out.println("Comida creada con éxito.");
        } else {
            System.out.println("No tienes suficiente dinero para crear esta comida.");
        }
    }

    private static void sellDish(Scanner scanner) {
        System.out.println("Inventario de Platos:");
        int dishCount = 1;

        // Imprimir platos de postre (Dessert)
        for (Dessert dessert : dessertInventory) {
            System.out.println(dishCount + ". Nombre: " + dessert.getName() + ", Precio de venta: $" + dessert.calculateSellingPrice());
            dishCount++;
        }

        // Imprimir bebidas (Drink)
        for (Drink drink : drinkInventory) {
            System.out.println(dishCount + ". Nombre: " + drink.getName() + ", Precio de venta: $" + drink.calculateSellingPrice());
            dishCount++;
        }

        // Imprimir comidas (Food)
        for (Food food : foodInventory) {
            System.out.println(dishCount + ". Nombre: " + food.getName() + ", Precio de venta: $" + food.calculateSellingPrice());
            dishCount++;
        }

        System.out.print("Seleccione el número del plato que desea vender (1-" + (dishCount - 1) + "): ");
        int selectedDishNumber = scanner.nextInt();

        if (selectedDishNumber >= 1 && selectedDishNumber < dishCount) {
            int index = selectedDishNumber - 1;

            // Obtener el plato seleccionado del inventario
            if (index < dessertInventory.size()) {
                Dessert dessert = dessertInventory.get(index);
                currentMoney += dessert.calculateSellingPrice();
                dessertInventory.remove(index);
            } else if (index < dessertInventory.size() + drinkInventory.size()) {
                Drink drink = drinkInventory.get(index - dessertInventory.size());
                currentMoney += drink.calculateSellingPrice();
                drinkInventory.remove(index - dessertInventory.size());
            } else {
                Food food = foodInventory.get(index - dessertInventory.size() - drinkInventory.size());
                currentMoney += food.calculateSellingPrice();
                foodInventory.remove(index - dessertInventory.size() - drinkInventory.size());
            }

            System.out.println("Plato vendido con éxito. Dinero actual: $" + currentMoney);
        } else {
            System.out.println("Número de plato no válido. Por favor, seleccione un número de plato válido.");
        }
    }

}
