package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Modelos.Tablero;
import Modelos.TableroGanador;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


public class Juego {

	private JFrame frame;
	
	Tablero tablero = new Tablero();
	TableroGanador tableroGanador = new TableroGanador();
	JPanel panel_botones = new JPanel();
	JPanel panel_movimientos = new JPanel();
	
	JLabel labelPuntaje = new JLabel("Movimientos: 0");
	private JButton[][] botones; 
	
    boolean mostrarNumeros = false;


//-----------------------------------------------------------------------------------------------------------------------------------

	private void inicializarBotones() {
	    botones = new JButton[4][4];
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    
	    panel_botones.setPreferredSize(new Dimension(661, 500)); 
	    panel_botones.setLayout(new GridLayout(4, 4, 0, 0));
	    frame.getContentPane().add(panel_botones, BorderLayout.CENTER); 
	    
	  
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            botones[i][j] = new JButton();
	            panel_botones.add(botones[i][j]);
	        }
	    }
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------

	 private void inicializarPanelMovimientos() {
	    panel_movimientos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
	    panel_movimientos.setBackground(new Color(25, 25, 112));
	    panel_movimientos.setPreferredSize(new Dimension(660, 100)); 
	    panel_movimientos.setLayout(null);
	    labelPuntaje.setForeground(new Color(255, 255, 255));
	    labelPuntaje.setFont(new Font("Monospaced", Font.BOLD, 20));
	    labelPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_movimientos.add(labelPuntaje);
	    labelPuntaje.setBounds(544, 27, 200, 50); 
	    frame.getContentPane().add(panel_movimientos, BorderLayout.SOUTH);

	}
		
//-----------------------------------------------------------------------------------------------------------------------------------

	 
	 private void botonAyuda() {
		 
		    JButton btnAyuda = new JButton("?");
		    btnAyuda.setBounds(44, 28, 133, 50); 
		    btnAyuda.setFont(new Font("Arial Black", Font.PLAIN, 16));
		    panel_movimientos.add(btnAyuda);
		    
		    btnAyuda.addActionListener(e -> {
		        mostrarNumeros = !mostrarNumeros;  
		        actualizarBotones(tablero);  
		        frame.requestFocusInWindow();
		    });

	 }
	 
//-----------------------------------------------------------------------------------------------------------------------------------

	 private void actualizarBotones(Tablero tablero2) {
		    int[][] matriz = tablero2.getTablero();
		    for (int i = 0; i < matriz.length; i++) {
		        for (int j = 0; j < matriz[0].length; j++) {
		            if (i < botones.length && j < botones[i].length) {
		                if (matriz[i][j] == 16) {
		                    botones[i][j].setText("");
		                } else {
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
	            if (mostrarNumeros) {
	                botones[i][j].setText(texto); 
	                botones[i][j].setIcon(null);  
	            } else {
	                if (!texto.isEmpty()) {
	                    int numero = Integer.parseInt(texto);
	                    String rutaImagen = "/Imagenes/" + numero + ".jpg"; 
	                    ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
	                    botones[i][j].setIcon(icono);  // Muestra la imagen
	                } else {
	                    botones[i][j].setIcon(new ImageIcon("/Imagenes/16.jpg"));
	                }
	            }
	        }
	    }
	}

//-----------------------------------------------------------------------------------------------------------------------------------

	private void actualizarPuntaje() {
	    int movimientos = Tablero.getMovimientos(); 
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
	
	
	
	private boolean limiteMovimientos() {
		if(Tablero.getMovimientos() < 20) {
		return false;
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
		frame.setResizable(false);
		
		
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
		        System.out.println(Tablero.getMovimientos());
		        
		        if (verificarGanador()) {
		        	frame.setVisible(false);
					Win.main(null);
		        } else if (limiteMovimientos()) {
					frame.setVisible(false);
					GameOver.main(null);
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
		frame.setTitle("- - - - |||| R O M P E C A B E Z A S  D E S L I Z A N T E  |||| - - - - 			Jugador: " + Menu.getNombre());
		
		botonAyuda();
		tablero.setMovimientos(0);
		inicializarBotones();
		inicializarPanelMovimientos();
		actualizarBotones(tablero);
		
		System.out.print(Menu.getNombre());	
		
	}
}

