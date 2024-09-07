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

public class GameOver {

	private JFrame frame;

	
	public void panelPededor() {
	JTextPane txtpnPuntuacion = new JTextPane();
	txtpnPuntuacion.setEditable(false);
	txtpnPuntuacion.setFont(new Font("Arial Black", Font.PLAIN, 20));
	txtpnPuntuacion.setText(Menu.getNombre() + " Perdiste " );
	txtpnPuntuacion.setBounds(264, 311, 195, 35);
	frame.getContentPane().add(txtpnPuntuacion);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	
	public void panelMovimientos() {
	JTextPane txtpnPuntuacion = new JTextPane();
	txtpnPuntuacion.setEditable(false);
	txtpnPuntuacion.setFont(new Font("Arial Black", Font.PLAIN, 20));
	txtpnPuntuacion.setText("cantidad de movimientos : " + Tablero.getMovimientos());
	txtpnPuntuacion.setBounds(197, 384, 357, 35);
	frame.getContentPane().add(txtpnPuntuacion);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public void botonVolverJugar() {
	JButton btnNewButton = new JButton("volver a jugar");
	btnNewButton.setBounds(122, 539, 150, 23);
	frame.getContentPane().add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Menu.main(null);
		}
	});
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public void botonSalirJuego() {
		JButton btnNewButton_1 = new JButton("salir del juego");
		btnNewButton_1.setBounds(469, 539, 150, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void labelFondo() {
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBounds(0, 0, 754, 701);
	frame.getContentPane().add(lblNewLabel);
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

	
	
	
	public GameOver() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();	
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
