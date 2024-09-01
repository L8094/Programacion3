package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Modelos.Tablero;
import Modelos.TableroGanador;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class MainForm {

	private JFrame frame;
	
	Tablero tablero = new Tablero();
	TableroGanador tableroGanador = new TableroGanador();

	
	private JButton[][] botones; 

//-----------------------------------------------------------------------------------------------------------------------------------

	private void inicializarBotones() {
	    botones = new JButton[4][4]; 
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            botones[i][j] = new JButton();            
	            frame.getContentPane().add(botones[i][j]);
	        }
	    }
	    frame.getContentPane().setLayout(new GridLayout(4, 4)); 
	}
		
//-----------------------------------------------------------------------------------------------------------------------------------

	private void actualizarBotones(Tablero tablero2) {
	    int[][] matriz = tablero2.getTablero();
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[0].length; j++) {
	            if (i < botones.length && j < botones[i].length) {
	            	if(matriz[i][j]==16) {
	            		botones[i][j].setText("");
	            	}else {
	            		botones[i][j].setText(String.valueOf(matriz[i][j]));
	            	}	                	         
	            }
	        }
	        cargarImagenes();
	    }
	    frame.revalidate();
	    frame.repaint();
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	

	private void cargarImagenes() {
	    for (int i = 0; i < botones.length; i++) {
	        for (int j = 0; j < botones[i].length; j++) {
	            String texto = botones[i][j].getText(); 
	            if (!texto.isEmpty()) {
	                int numero = Integer.parseInt(texto); 
	                String rutaImagen = "/Imagenes/" + numero + ".jpg"; 
	                ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen)); 
	                botones[i][j].setIcon(icono); 
	            } else {
	                botones[i][j].setIcon(new ImageIcon("/Imagenes/16.jpg")); 
	            }
	        }
	    }
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	
	private boolean verificarGanador() {
	    int[][] matrizActual = tablero.getTablero();
	    int[][] matrizGanadora = tableroGanador.getTablero(); 

	    for (int i = 0; i < matrizActual.length; i++) {
	        for (int j = 0; j < matrizActual[i].length; j++) {
	            if (matrizActual[i][j] != matrizGanadora[i][j]) {
	                return false; 
	            }
	        }
	    }
	    return true; 
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	

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

//--------------------------------------- C R E A - L A - A P L I C A C I O N ----------------------------------------------------------
	public MainForm() {
		initialize();
	}

//--------------------------------------------- I N I C I A - F R A M E ----------------------------------------------------------------	    	
	
	private void initialize() {
		frame = new JFrame();
		
		
		frame.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		        int keyCode = e.getKeyCode();
		        
		        if (keyCode == KeyEvent.VK_UP) {
		            tablero.moverArriba();
		        } else if (keyCode == KeyEvent.VK_DOWN) {
		            tablero.moverAbajo();
		        } else if (keyCode == KeyEvent.VK_LEFT) {
		            tablero.moverIzquierda();
		        } else if (keyCode == KeyEvent.VK_RIGHT) {
		            tablero.moverDerecha();
		        } else {
		            return; 
		        }
		        
		        actualizarBotones(tablero);
		        
		        if (verificarGanador()) {
		            JOptionPane.showMessageDialog(frame, "¡Felicidades, has ganado!");
		            // Aquí podrías finalizar el juego o reiniciarlo
		            // frame.dispose(); // Para cerrar la ventana
		        }
		    }
		});

	    
	    frame.setFocusable(true); 
	    frame.requestFocusInWindow();
	
		
		frame.setBounds(60, 60, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));
		
//----------------------------------------------- I N I C I A R - T A B L E R O - G A N A D O R--------------------------------------------		
		tableroGanador.initTablero();
	
//----------------------------------------------------- I N I C I A R - T A B L E R O -----------------------------------------------------		
	
		tablero.initTablero();	
		tablero.imprimirTablero();
//----------------------------------------------- I N I C I A R - F U N C I O N E S - F R A M E--------------------------------------------
		
		inicializarBotones();
		actualizarBotones(tablero);
		
		
	}

	
}
