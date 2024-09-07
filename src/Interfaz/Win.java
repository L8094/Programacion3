package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import Modelos.Tablero;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class Win {

	private JFrame frame;
	
//-----------------------------------------------------------------------------------------------------------------------------------		
	public void panelGanador() {
		JTextPane txtpnPuntuacion = new JTextPane();
		txtpnPuntuacion.setEditable(false);
		txtpnPuntuacion.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtpnPuntuacion.setText("Felicitaciones " + Menu.getNombre() + " ganaste " );
		txtpnPuntuacion.setBounds(199, 303, 342, 35);
		frame.getContentPane().add(txtpnPuntuacion);
		}

//-----------------------------------------------------------------------------------------------------------------------------------	

	public void panelMovimientos() {
	JTextPane txtpnPuntuacion = new JTextPane();
	txtpnPuntuacion.setEditable(false);
	txtpnPuntuacion.setFont(new Font("Arial Black", Font.PLAIN, 20));
	txtpnPuntuacion.setText("cantidad de movimientos : " + Tablero.getMovimientos());
	txtpnPuntuacion.setBounds(187, 370, 365, 35);
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
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(0, 0, 754, 701);
	frame.getContentPane().add(lblNewLabel);
	}
	

//-----------------------------------------------------------------------------------------------------------------------------------	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win window = new Win();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Win() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(60, 20, 770, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelGanador();
		
		panelMovimientos();
		
		botonVolverJugar();
		
		botonSalirJuego();	
		
		labelFondo();	
		
	}
}
