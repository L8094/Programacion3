package Interfaz;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Modelos.Tablero;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MainForm {

	private JFrame frame;
	
	Tablero tablero = new Tablero();
	
//	private void cargarBotones(Tablero tablero2) {
//		int[][] matriz = tablero2.getTablero();
//	    for (int i = 0; i < matriz.length; i++) {
//	    	for (int j = 0; j < matriz[0].length; j++) {
//	            JButton btn = new JButton(String.valueOf(matriz[i][j]));
//	            // A�adir el bot�n al panel
//	            frame.getContentPane().add(btn);
//	        }
//	    }
//	}
	
	
	private JButton[][] botones; // Una matriz para almacenar los botones

	private void inicializarBotones() {
	    botones = new JButton[4][4]; // Inicializa la matriz de botones

	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            botones[i][j] = new JButton(); // Crea un nuevo botón
	            // Configuración del botón si es necesario (como tamaño, fondo, etc.)
	            frame.getContentPane().add(botones[i][j]);
	        }
	    }

	    frame.getContentPane().setLayout(new GridLayout(4, 4)); // Configura el layout
	}
	
	private void actualizarBotones(Tablero tablero2) {
	    int[][] matriz = tablero2.getTablero();

	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[0].length; j++) {
	            // Asegúrate de que estás dentro de los límites de la matriz de botones
	            if (i < botones.length && j < botones[i].length) {
	            	if(matriz[i][j]==16) {
	            		botones[i][j].setText("");
	            	}else {
	            		botones[i][j].setText(String.valueOf(matriz[i][j]));
	            	}
	                
	                // O si estás usando imágenes, puedes usar:
	                // botones[i][j].setIcon(new ImageIcon(...)); // con la imagen adecuada
	            }
	        }
	    }
	    
	    // Refrescar la interfaz para que los cambios se muestren
	    frame.revalidate();
	    frame.repaint();
	}
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
    	
	
	private void initialize() {
		frame = new JFrame();
		//escucha si se presiono una tecla
		frame.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            int keyCode = e.getKeyCode();
	            switch (keyCode) {
	                case KeyEvent.VK_UP:
	                    tablero.moverAbajo();
	                    return;
	                case KeyEvent.VK_DOWN:
	                    tablero.moverArriba();
	                    return;
	                case KeyEvent.VK_LEFT:
	                    tablero.moverDerecha();
	                    return;
	                case KeyEvent.VK_RIGHT:
	                    tablero.moverIzquierda();
	                    return;
	            }
	            actualizarBotones(tablero); // Actualizar los botones después del movimiento
	        }
	    });
	    
	    frame.setFocusable(true); // Asegúrate de que el frame puede recibir el foco para detectar teclas
	    frame.requestFocusInWindow();
	
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));
		tablero.initTablero();	
		tablero.imprimirTablero();
		//cargarBotones(tablero);
		inicializarBotones();
		actualizarBotones(tablero);
		
		
	}

	
}
