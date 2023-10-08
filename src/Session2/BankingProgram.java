package Session2;
import java.util.Scanner;

public class BankingProgram {
    private static String ownerName;
    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.print("Por favor, introduce tu nombre: ");
        ownerName = scanner.nextLine(); // Lee el nombre del usuario

        System.out.println("¡Bienvenido, " + ownerName + "!");

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Ver Saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Depositar");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verSaldo();
                    break;
                case 2:
                    retirar(scanner);
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }

    private static void verSaldo() {
        System.out.println("Saldo actual de la cuenta de " + ownerName + ": $" + balance);
    }

    private static void retirar(Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: $");
        double cantidadRetirar = scanner.nextDouble();

        if (cantidadRetirar <= balance) {
            balance -= cantidadRetirar;
            System.out.println("Retiro exitoso. Saldo restante: $" + balance);
        } else {
            System.out.println("Fondos insuficientes. Saldo actual: $" + balance);
        }
    }

    private static void depositar(Scanner scanner) {
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidadDepositar = scanner.nextDouble();

        if (cantidadDepositar > 0) {
            balance += cantidadDepositar;
            System.out.println("Depósito exitoso. Saldo actual: $" + balance);
        } else {
            System.out.println("Cantidad de depósito no válida.");
        }
    }
}
