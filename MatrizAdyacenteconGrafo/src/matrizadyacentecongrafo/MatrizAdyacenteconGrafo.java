package matrizadyacentecongrafo;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.Scanner;

public class MatrizAdyacenteconGrafo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de nodos en el grafo: ");
        int numNodos = scanner.nextInt();

        int[][] matrizAdyacencia = new int[numNodos][numNodos];
        Graph grafo = new SingleGraph("Grafo");

        // Agregar nodos al grafo
        for (int i = 0; i < numNodos; i++) {
            Node nodo = grafo.addNode(Integer.toString(i));
            nodo.addAttribute("ui.label", Integer.toString(i));
        }

        // Consultar los nodos a comunicar hasta que todos los nodos estén conectados
        int nodosRestantes = numNodos;
        while (nodosRestantes > 1) {
            System.out.print("Ingrese el primer nodo a comunicar (0-" + (numNodos - 1) + "): ");
            int nodo1 = scanner.nextInt();
            System.out.print("Ingrese el segundo nodo a comunicar (0-" + (numNodos - 1) + "): ");
            int nodo2 = scanner.nextInt();

            // Verificar si los nodos ya están comunicados
            if (matrizAdyacencia[nodo1][nodo2] > 0 || matrizAdyacencia[nodo2][nodo1] > 0) {
                System.out.println("Los nodos ya están comunicados. Ingrese nodos diferentes.");
                continue;
            }

            System.out.print("Ingrese el peso del camino entre el nodo " + nodo1 + " y el nodo " + nodo2 + ": ");
            int peso = scanner.nextInt();

            // Establecer la conexión entre los nodos
            matrizAdyacencia[nodo1][nodo2] = peso;
            matrizAdyacencia[nodo2][nodo1] = peso;

            if (peso > 0) {
                grafo.addEdge(nodo1 + "-" + nodo2, Integer.toString(nodo1), Integer.toString(nodo2), true)
                        .addAttribute("ui.label", Integer.toString(peso));
            }

            System.out.println("Los nodos " + nodo1 + " y " + nodo2 + " se han comunicado.");

            nodosRestantes = contarNodosRestantes(matrizAdyacencia);
        }

        // Mostrar la matriz de adyacencia
        System.out.println("\nMatriz de adyacencia:");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }

        // Graficar el grafo
        grafo.display();
    }

    // Método para contar los nodos restantes sin conexión
    private static int contarNodosRestantes(int[][] matrizAdyacencia) {
        int nodosRestantes = 0;
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            boolean conectado = false;
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[i][j] > 0 || matrizAdyacencia[j][i] > 0) {
                    conectado = true;
                    break;
                }
            }
            if (!conectado) {
                nodosRestantes++;
            }
        }
        return nodosRestantes;
    }
}
