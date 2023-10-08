package Session2;
import java.util.Scanner;

public class GeometricFigures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaramos las variables que almacenarán los valores de entrada
        int baseRectangulo, alturaRectangulo, ladoCuadrado, baseTriangulo, alturaTriangulo, lado1Triangulo, lado2Triangulo, lado3Triangulo;

        // Solicitamos los valores de entrada para el rectángulo
        System.out.println("Ingrese la base del rectángulo: ");
        baseRectangulo = sc.nextInt();
        System.out.println("Ingrese la altura del rectángulo: ");
        alturaRectangulo = sc.nextInt();

        // Solicitamos los valores de entrada para el cuadrado
        System.out.println("Ingrese el lado del cuadrado: ");
        ladoCuadrado = sc.nextInt();

        // Solicitamos los valores de entrada para el triángulo
        System.out.println("Ingrese la base del triángulo: ");
        baseTriangulo = sc.nextInt();
        System.out.println("Ingrese la altura del triángulo: ");
        alturaTriangulo = sc.nextInt();
        System.out.println("Ingrese el lado 1 del triángulo: ");
        lado1Triangulo = sc.nextInt();
        System.out.println("Ingrese el lado 2 del triángulo: ");
        lado2Triangulo = sc.nextInt();
        System.out.println("Ingrese el lado 3 del triángulo: ");
        lado3Triangulo = sc.nextInt();

        // Creamos las instancias de las figuras
        Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);
        Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
        Triangulo triangulo = new Triangulo(baseTriangulo, alturaTriangulo, lado1Triangulo, lado2Triangulo, lado3Triangulo);

        // Calculamos las áreas y perímetros de las figuras
        int areaRectangulo = rectangulo.calcularArea();
        int perimetroRectangulo = rectangulo.calcularPerimetro();

        int areaCuadrado = cuadrado.calcularArea();
        int perimetroCuadrado = cuadrado.calcularPerimetro();

        double areaTriangulo = triangulo.calcularArea();
        int perimetroTriangulo = triangulo.calcularPerimetro();

        // Imprimimos los resultados
        System.out.println("El área del rectángulo es: " + areaRectangulo);
        System.out.println("El perímetro del rectángulo es: " + perimetroRectangulo);

        System.out.println("El área del cuadrado es: " + areaCuadrado);
        System.out.println("El perímetro del cuadrado es: " + perimetroCuadrado);

        System.out.println("El área del triángulo es: " + areaTriangulo);
        System.out.println("El perímetro del triángulo es: " + perimetroTriangulo);
    }

    static class Cuadrado {
        private int lado;

        public Cuadrado(int lado) {
            this.lado = lado;
        }

        public int calcularArea() {
            return lado * lado;
        }

        public int calcularPerimetro() {
            return lado * 4;
        }
    }

    static class Rectangulo {
        private int base;
        private int altura;

        public Rectangulo(int base, int altura) {
            this.base = base;
            this.altura = altura;
        }

        public int calcularArea() {
            return base * altura;
        }

        public int calcularPerimetro() {
            return 2 * (base + altura);
        }
    }

    static class Triangulo {
        private int base;
        private int altura;
        private int lado1;
        private int lado2;
        private int lado3;

        public Triangulo(int base, int altura, int lado1, int lado2, int lado3) {
            this.base = base;
            this.altura = altura;
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }

        public double calcularArea() {
            return (base * altura) / 2.0; // Área de un triángulo
        }

        public int calcularPerimetro() {
            return lado1 + lado2 + lado3;
        }
    }
}