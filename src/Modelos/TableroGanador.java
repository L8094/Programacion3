package Modelos;

import java.util.ArrayList;
import java.util.Collections;

public class TableroGanador {

    private int[][] tablero;
    public static final int size = 4;

    ArrayList<Integer> piezas = new ArrayList<>();

// ------------------------------------------- C O N S T R U C T O R ------------------------------------------------------------------
    
    public TableroGanador() {
    	
        tablero = new int[size][size];
        piezas = new ArrayList<>();
    }

//-----------------------------------------------------------------------------------------------------------------------------------------    
    
    public void initTablero() {
        try {
            this.cargarPiezas();
            this.cargarTablero();
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

	public int[][] getTablero() {
		 return tablero;
	
	}
}
