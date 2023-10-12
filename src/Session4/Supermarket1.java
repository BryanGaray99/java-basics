package Session4;

import java.util.ArrayList;

class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private boolean enVenta;

    public Producto(int id, String nombre, double precio, int cantidad, boolean enVenta) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.enVenta = enVenta;
    }

    public String getName() {
        return nombre;
    }
}

public class Supermarket1 {
    public static void main(String[] args) {
        ArrayList<Producto> lista_productos = new ArrayList<>();
        Producto Arroz = new Producto(1, "Arroz", 2.0, 10, true);
        lista_productos.add(Arroz);

        Producto Aceite = new Producto(2, "Aceite", 2.0, 10, true);
        lista_productos.add(Aceite);

        System.out.println(lista_productos.size());
        for (int i = 0; i < lista_productos.size(); i++) {
            System.out.println(lista_productos.get(i).getName());
        }
    }
}