package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Modelos.Tablero;
import Modelos.TableroGanador;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;


public class Juego {

	private JFrame frame;
	
	Tablero tablero = new Tablero();
	TableroGanador tableroGanador = new TableroGanador();
	JPanel panel_numeros = new JPanel();
	JPanel panel_movimientos = new JPanel();
	
	JLabel labelPuntaje = new JLabel();
	private JButton[][] botones; 

//-----------------------------------------------------------------------------------------------------------------------------------

	private void inicializarBotones() {
	    botones = new JButton[4][4];
	    
	    // Cambiamos el layout del frame al BorderLayout para gestionar mejor los paneles
	    frame.getContentPane().setLayout(new BorderLayout());
	    
	    // Configuración del panel de números
	    panel_numeros.setBackground(Color.DARK_GRAY);
	    panel_numeros.setPreferredSize(new Dimension(661, 500)); // Tamaño deseado
	    panel_numeros.setLayout(new GridLayout(4, 4, 0, 0));
	    frame.getContentPane().add(panel_numeros, BorderLayout.CENTER); // Añadimos en el centro
	    
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            botones[i][j] = new JButton();
	            panel_numeros.add(botones[i][j]);
	        }
	    }

	    // Configuración del panel de movimientos
	    panel_movimientos.setBackground(Color.WHITE);
	    panel_movimientos.setPreferredSize(new Dimension(660, 100)); // Tamaño deseado
	    panel_movimientos.setLayout(null); // Mantén el null layout si quieres usar setBounds()
	    labelPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    // Agregamos el label con la posición adecuada dentro del panel
	    panel_movimientos.add(labelPuntaje);
	    labelPuntaje.setBounds(251, 28, 200, 50); // Ajusta el tamaño y la posición del label
	   
	    
	    // Añadimos el panel de movimientos en la parte inferior (SOUTH)
	    frame.getContentPane().add(panel_movimientos, BorderLayout.SOUTH);
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

	private void actualizarPuntaje() {
	    int movimientos = tablero.getMovimientos(); 
	    labelPuntaje.setText("Movimientos: " + movimientos);
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
					Juego window = new Juego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//--------------------------------------- C R E A - L A - A P L I C A C I O N ----------------------------------------------------------
	public Juego() {
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
		        actualizarPuntaje();
		        
		        if (verificarGanador()) {
		            JOptionPane.showMessageDialog(frame, "¡Felicidades, has ganado!");
		            // Aquí podrías finalizar el juego o reiniciarlo
		            // frame.dispose(); // Para cerrar la ventana
		        }
		    }
		});

	    
	    frame.setFocusable(true); 
	    frame.requestFocusInWindow();
	
		
		frame.setBounds(60, 20, 770, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//----------------------------------------------- I N I C I A R - T A B L E R O - G A N A D O R--------------------------------------------		
		tableroGanador.initTablero();
	
//----------------------------------------------------- I N I C I A R - T A B L E R O -----------------------------------------------------		
	
		tablero.initTablero();	
		tablero.imprimirTablero();
//----------------------------------------------- I N I C I A R - F U N C I O N E S - F R A M E--------------------------------------------
		tablero.setMovimientos(0);
		inicializarBotones();
		actualizarBotones(tablero);
		 panel_movimientos.add(labelPuntaje);
		
		
	}
}
