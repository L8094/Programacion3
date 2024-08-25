package Modelos;

import java.util.ArrayList;
import java.util.Collections;

public class TableroGanador {

    private int[][] tablero;
    private int movimientos;
    public static final int size = 4;

    ArrayList<Integer> piezas = new ArrayList<>();

    // -------------------- C O N S T R U C T O R ---------------------------------
    public TableroGanador() {
        tablero = new int[size][size];
        piezas = new ArrayList<>();
    }

    public void initTablero() {
        try {
            this.cargarPiezas();
            this.cargarTablero();
        } catch (Exception e) {
            System.err.println("Hubo un error al inicializar el tablero: " + e.getMessage());
        }
    }

    private void cargarTablero() {
        int piezaIndex = 0;  // Para mantener el índice de la pieza que se está colocando
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tablero[i][j] = piezas.get(piezaIndex);  // Asignar la pieza correspondiente a la posición (i,j)
                piezaIndex++;  // Avanzar al siguiente índice de la pieza
            }
        }
    }

    private void cargarPiezas() {
        for (int i = 1; i <= size * size; i++) {
            piezas.add(i);  // Cargar las piezas del 1 al 16
        }
        // Asegúrate de que las piezas estén ordenadas
        Collections.sort(piezas);
    }

    // Método para imprimir el listado de piezas
    public void imprimirPiezas() {
        System.out.println("Piezas del tablero:");
        for (int pieza : piezas) {
            System.out.print(pieza + " ");
        }
        System.out.println(); // Para un salto de línea al final
    }

    // Método para imprimir el tablero en forma de matriz
    public void imprimirTablero() {
        System.out.println("Tablero:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(); // Para un salto de línea al final de cada fila
        }
    }

    public static void main(String[] args) {
        TableroGanador tablero = new TableroGanador();
        tablero.initTablero(); // Inicializa el tablero y las piezas
        tablero.imprimirPiezas(); // Imprime las piezas
        tablero.imprimirTablero(); // Imprime el tablero
    }
}
