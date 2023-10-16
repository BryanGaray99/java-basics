package Session4;
import java.util.ArrayList;
import java.util.Scanner;
class PlatoMenu {
    private String nombre;
    private double precio;

    public PlatoMenu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

public class MenuRestaurante {
    public static void main(String[] args) {
        ArrayList<PlatoMenu> menu = new ArrayList<>();

        // Agregar algunos platos por defecto
        menu.add(new PlatoMenu("Espagueti a la Carbonara", 12.99));
        menu.add(new PlatoMenu("Pizza Margarita", 10.99));
        menu.add(new PlatoMenu("Ensalada Vegana", 8.99));
        menu.add(new PlatoMenu("Sándwich de Pollo a la Parrilla", 9.99));
        menu.add(new PlatoMenu("Pastel de Chocolate", 6.99));

        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n*** Menú del Restaurante ***");
            System.out.println("1. Agregar un plato al menú");
            System.out.println("2. Reemplazar un plato en el menú");
            System.out.println("3. Mostrar la cantidad de platos en el menú");
            System.out.println("4. Mostrar todo el menú");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del nuevo plato: ");
                    scanner.nextLine(); // Consumir la nueva línea
                    String nombrePlato = scanner.nextLine();
                    System.out.print("Precio del nuevo plato: ");
                    double precioPlato = scanner.nextDouble();
                    menu.add(new PlatoMenu(nombrePlato, precioPlato));
                    System.out.println("Se ha agregado un nuevo plato al menú.");
                    break;

                case 2:
                    System.out.println("Platos actuales en el menú:");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println(i + ". " + menu.get(i).getNombre() + " - $" + menu.get(i).getPrecio());
                    }
                    System.out.print("Ingresa el índice del plato a reemplazar: ");
                    int indice = scanner.nextInt();

                    if (indice >= 0 && indice < menu.size()) {
                        System.out.print("Nombre del nuevo plato: ");
                        scanner.nextLine(); // Consumir la nueva línea
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Precio del nuevo plato: ");
                        double nuevoPrecio = scanner.nextDouble();

                        menu.set(indice, new PlatoMenu(nuevoNombre, nuevoPrecio));
                        System.out.println("Plato reemplazado con éxito.");
                    } else {
                        System.out.println("Índice no válido. Por favor, ingresa un índice válido.");
                    }
                    break;

                case 3:
                    System.out.println("Número de platos en el menú: " + menu.size());
                    break;

                case 4:
                    System.out.println("Menú del Restaurante:");
                    for (PlatoMenu plato : menu) {
                        System.out.println(plato.getNombre() + " - $" + plato.getPrecio());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close(); // Cerrar el scanner al final del programa
    }
}