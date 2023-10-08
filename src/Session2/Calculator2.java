package Session2;

import java.util.Scanner;

public class Calculator2 {
    private double result; // Para almacenar el resultado

    public Calculator2() {
        result = 0.0; // Inicializa el resultado en 0 al crear un nuevo objeto Calculator
    }

    public double getResult() {
        return result; // Devuelve el valor actual del resultado
    }

    public void add(double num) {
        result += num; // Suma el número dado al resultado
    }

    public void subtract(double num) {
        result -= num; // Resta el número dado del resultado
    }

    public void multiply(double num) {
        result *= num; // Multiplica el resultado por el número dado
    }

    public void divide(double num) {
        if (num != 0) {
            result /= num; // Divide el resultado por el número dado (evita la división por cero)
        } else {
            System.out.println("Error: División por cero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator2 calculator = new Calculator2();

        System.out.println("Calculadora instanciada. Resultado inicial: " + calculator.getResult());

        System.out.print("Ingrese el número a sumar: ");
        double numToAdd = scanner.nextDouble();
        calculator.add(numToAdd);

        System.out.print("Ingrese el número a restar: ");
        double numToSubtract = scanner.nextDouble();
        calculator.subtract(numToSubtract);

        System.out.print("Ingrese el número a multiplicar: ");
        double numToMultiply = scanner.nextDouble();
        calculator.multiply(numToMultiply);

        System.out.print("Ingrese el número a dividir: ");
        double numToDivide = scanner.nextDouble();
        calculator.divide(numToDivide);

        System.out.println("Resultado final: " + calculator.getResult());

        scanner.close();
    }
}