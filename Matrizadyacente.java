import java.util.Scanner;

public class Matrizadyacente{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el tamaño de la matriz: ");
            int filasColumnas = scanner.nextInt();
            filasColumnas = filasColumnas + 1;
            int[][] matriz = new int[filasColumnas][filasColumnas];

            // Llenar la matriz con ceros
            for (int i = 1; i < filasColumnas; i++) {
                for (int j = 1; j < filasColumnas; j++) {
                    matriz[i][j] = 0;
                }
            }

            System.out.println("La matriz inicializada con ceros es:");
            mostrarMatriz(matriz);

            System.out.println("Ingrese la fila y columna donde desea ingresar un valor distinto de cero:");
            System.out.print("Fila: ");
            int fila = scanner.nextInt();
            System.out.print("Columna: ");
            int columna = scanner.nextInt();

            System.out.print("Ingrese el valor a ingresar en la posición (" + fila + ", " + columna + "): ");
            int valor = scanner.nextInt();

            // Asignar el valor ingresado en la posición especificada
            matriz[fila][columna] = valor;

            System.out.println("La matriz resultante es:");
            mostrarMatriz(matriz);
        }
    }

    // Método para mostrar la matriz por pantalla
    private static void mostrarMatriz(int[][] matriz) {
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
