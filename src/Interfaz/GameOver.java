package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import Modelos.Tablero;
import javax.swing.ImageIcon;
import javax.swing.DropMode;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GameOver {

	private JFrame frame;

//-----------------------------------------------------------------------------------------------------------------------------------	

	public void panelPededor() {
		
			JLabel MsjLost = new JLabel("");
			MsjLost.setHorizontalAlignment(SwingConstants.CENTER);
			MsjLost.setFont(new Font("Monospaced", Font.BOLD, 40));
			MsjLost.setForeground(new Color(255, 255, 255));
			MsjLost.setBounds(0, 60, 754, 97);
			MsjLost.setText(( "Hasta la próxima "+ Menu.getNombre() ));
			frame.getContentPane().add(MsjLost);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void panelMovimientos() {
	
			JLabel MovimientosRealizados = new JLabel("New label");
			MovimientosRealizados.setFont(new Font("Monospaced", Font.BOLD, 30));
			MovimientosRealizados.setForeground(new Color(255, 255, 255));
			MovimientosRealizados.setHorizontalAlignment(SwingConstants.CENTER);
			MovimientosRealizados.setBounds(0, 550, 754, 69);
			MovimientosRealizados.setText("Movimientos realizados: " + Tablero.getMovimientos());
			frame.getContentPane().add(MovimientosRealizados);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public void botonVolverJugar() {
		
			JButton doItAgain = new JButton("Volver a jugar");
			doItAgain.setBounds(131, 619, 150, 35);
			frame.getContentPane().add(doItAgain);
			doItAgain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Menu.main(null);
				}});
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public void botonSalirJuego() {
		
			JButton exit = new JButton("Salir del juego");
			exit.setBounds(478, 619, 150, 35);
			frame.getContentPane().add(exit);
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}});
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void labelFondo() {
		
			JLabel Fondo = new JLabel("");
			Fondo.setIcon(new ImageIcon(GameOver.class.getResource("/Imagenes/gameOver.gif")));
			Fondo.setBounds(0, 0, 754, 701);
			frame.getContentPane().add(Fondo);
	}
	

//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GameOver window = new GameOver();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}

//-----------------------------------------------------------------------------------------------------------------------------------	

	public GameOver() {
		
			initialize();
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	private void initialize() {
	
			frame = new JFrame();	
			frame.setTitle("	P E R D I S T E ! ! ! ");
			frame.setResizable(false);
			frame.setBounds(60, 20, 770, 740);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			panelPededor();
			panelMovimientos();
			botonVolverJugar();
			botonSalirJuego();	
			labelFondo();	
		}
	}
