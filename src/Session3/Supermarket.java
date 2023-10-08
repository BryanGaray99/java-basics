package Session3;

import java.util.Scanner;

class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private boolean enVenta;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.enVenta = false;
    }

    public void ponerEnVenta() {
        enVenta = true;
    }

    public void quitarDeLaVenta() {
        enVenta = false;
    }

    public void vender(int cantidad) {
        if (enVenta && cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
        }
    }

    public boolean estaEnVenta() {
        return enVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", En Venta: " + enVenta;
    }
}

public class Supermarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear productos e inventario
        Producto producto1 = new Producto(1, "Pasta de Dientes", 2.99, 50);
        Producto producto2 = new Producto(2, "Aceite 2 Lt", 1.49, 30);
        Producto producto3 = new Producto(3, "Leche 1 Lt", 1.99, 20);
        Producto producto4 = new Producto(4, "Arroz 3 Kg", 3.49, 40);
        Producto producto5 = new Producto(5, "Azucar 1 Kg", 0.90, 60);

        int choice;
        do {
            System.out.println("\nSupermarket Menu:");
            System.out.println("1. Añadir un producto a la venta");
            System.out.println("2. Listar los precios y nombres de los productos en venta");
            System.out.println("3. Vender productos");
            System.out.println("4. Quitar productos de la venta");
            System.out.println("5. Salir");

            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    agregarProductoAVenta(scanner, producto1, producto2, producto3, producto4, producto5);
                    break;
                case 2:
                    listarProductosEnVenta(producto1, producto2, producto3, producto4, producto5);
                    break;
                case 3:
                    venderProductos(scanner, producto1, producto2, producto3, producto4, producto5);
                    break;
                case 4:
                    removerProductosDelInventario(scanner, producto1, producto2, producto3, producto4, producto5);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void agregarProductoAVenta(Scanner scanner, Producto... productos) {
        System.out.print("Ingrese el ID del producto a poner en venta: ");
        int id = scanner.nextInt();
        Producto producto = null;

        for (Producto p : productos) {
            if (p.getId() == id) {
                producto = p;
                break;
            }
        }

        if (producto != null && !producto.estaEnVenta()) {
            producto.ponerEnVenta();
            System.out.println("Producto " + producto.getNombre() + " puesto en venta.");
        } else {
            System.out.println("El producto ya está en venta o no existe.");
        }
    }

    private static void listarProductosEnVenta(Producto... productos) {
        System.out.println("Productos en venta:");
        for (Producto p : productos) {
            if (p.estaEnVenta()) {
                System.out.println(p.getNombre() + " - Precio: $" + p.getPrecio());
            }
        }
    }

    private static void venderProductos(Scanner scanner, Producto... productos) {
        System.out.print("Ingrese el ID del producto a vender: ");
        int sellId = scanner.nextInt();
        Producto sellProducto = null;

        for (Producto p : productos) {
            if (p.getId() == sellId) {
                sellProducto = p;
                break;
            }
        }

        if (sellProducto != null && sellProducto.estaEnVenta()) {
            System.out.println("Producto: " + sellProducto.getNombre());
            System.out.println("Cantidad Disponible: " + sellProducto.getCantidad());

            System.out.print("Ingrese la cantidad a vender: ");
            int cantidadVenta = scanner.nextInt();

            if (cantidadVenta <= sellProducto.getCantidad() && cantidadVenta > 0) {
                sellProducto.vender(cantidadVenta);
                System.out.println(cantidadVenta + " unidades de " + sellProducto.getNombre() + " vendidas.");

                if (sellProducto.getCantidad() == 0) {
                    sellProducto.quitarDeLaVenta();
                    System.out.println("El producto, se ha agotado.");
                }
            } else {
                System.out.println("Cantidad no válida o insuficiente para la venta.");
            }
        } else {
            System.out.println("El producto no está en venta o no existe.");
        }
    }


    private static void removerProductosDelInventario(Scanner scanner, Producto... productos) {
        System.out.print("Ingrese el ID del producto que quiere dejar de vender: ");
        int removeId = scanner.nextInt();
        Producto removeProducto = null;

        for (Producto p : productos) {
            if (p.getId() == removeId) {
                removeProducto = p;
                break;
            }
        }

        if (removeProducto != null) {
            removeProducto.quitarDeLaVenta();
            System.out.println(removeProducto.getNombre() + " removido de la venta.");
        } else {
            System.out.println("El producto no existe.");
        }
    }
}

