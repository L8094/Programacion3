package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tablero {

    private int[][] tablero;
    private static int movimientos;
    public static final int size = 4;
    private int cantDeMovPiezasAleatorias= 100;

    ArrayList<Integer> piezas;

// ---------------------------------------------- C O N S T R U C T O R -------------------------------------------------------------------
    public Tablero() {
    	
        tablero = new int[size][size];
        piezas = new ArrayList<>();
        movimientos = 0;
    }

//-----------------------------------------------------------------------------------------------------------------------------------------   
    
    public void initTablero() {
    	
        try {
            this.cargarPiezas();
            this.cargarTablero();
            this.moverAleatorio(cantDeMovPiezasAleatorias);
        } catch (Exception e) {
            System.err.println("Hubo un error al inicializar el tablero: " + e.getMessage());
        }
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------   

    private void cargarTablero() {
    	
        int piezaIndex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tablero[i][j] = piezas.get(piezaIndex);
                piezaIndex++;
            }
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------    
    
    private void cargarPiezas() {
    	
        for (int i = 1; i <= size * size; i++) {
            piezas.add(i); 
        }
        
        Collections.sort(piezas);
    }

//-----------------------------------------------------------------------------------------------------------------------------------------    
    
    public void imprimirPiezas() {
    	
        System.out.println("Piezas del tablero:");
        for (int pieza : piezas) {
            System.out.print(pieza + " ");
        }
        System.out.println();
    }

//-----------------------------------------------------------------------------------------------------------------------------------------    
    
    public void imprimirTablero() {
    	
        System.out.println("Tablero:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------
    
    public void moverIzquierda() {
    	
        int[] pos = encontrarPosicionVacia();
        int fila = pos[0];
        int columna = pos[1];
        if (columna > 0) { 
            tablero[fila][columna] = tablero[fila][columna - 1];
            tablero[fila][columna - 1] = 16;
            movimientos++;
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------   
 
    public void moverDerecha() {
    	
        int[] pos = encontrarPosicionVacia();
        int fila = pos[0];
        int columna = pos[1];
        if (columna < size - 1) {
            tablero[fila][columna] = tablero[fila][columna + 1];
            tablero[fila][columna + 1] = 16;
            movimientos++;
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------    
   
    public void moverArriba() {
    	
        int[] pos = encontrarPosicionVacia();
        int fila = pos[0];
        int columna = pos[1];
        if (fila > 0) {
            tablero[fila][columna] = tablero[fila - 1][columna];
            tablero[fila - 1][columna] = 16;
            movimientos++;
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------
    
    public void moverAbajo() {
    	
        int[] pos = encontrarPosicionVacia();
        int fila = pos[0];
        int columna = pos[1];
        if (fila < size - 1) {
            tablero[fila][columna] = tablero[fila + 1][columna];
            tablero[fila + 1][columna] = 16;
            movimientos++;
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------
    
    private int[] encontrarPosicionVacia() {
    	
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tablero[i][j] == 16) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------
    
    public void moverAleatorio(int cantidad) {
    	
    	Random random = new Random();
        int movimiento = random.nextInt(4);
        if (cantidad == 0) {
        return;
        }
        if(movimiento == 0) {
        	this.moverDerecha();
        }
        if(movimiento == 1) {
        	this.moverIzquierda();
        }
        if(movimiento == 2) {
        	this.moverArriba();
        }
        if(movimiento == 3) {
        	this.moverAbajo();
        }
        cantidad--;
        moverAleatorio(cantidad);
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------    
    
    public int[][] getTablero() {
        return tablero;
    }

	
	public static int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int i) {
		movimientos= i;
		
	}
	
	
}

