package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import Modelos.Tablero;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Win {

	private JFrame frame;
	
//-----------------------------------------------------------------------------------------------------------------------------------		
	public void panelGanador() {

			JLabel msjWin = new JLabel("");
			msjWin.setHorizontalAlignment(SwingConstants.CENTER);
			msjWin.setFont(new Font("Monospaced", Font.BOLD, 40));
			msjWin.setForeground(new Color(255, 255, 255));
			msjWin.setBounds(0, -24, 754, 97);
			msjWin.setText(( "Felicitaciones "+ Menu.getNombre()+ "!!!"));
			frame.getContentPane().add(msjWin);
		}
//-----------------------------------------------------------------------------------------------------------------------------------	

	public void panelMovimientos() {
		JLabel MovimientosRealizados = new JLabel("New label");
		MovimientosRealizados.setBackground(new Color(102, 51, 153));
		MovimientosRealizados.setFont(new Font("Monospaced", Font.BOLD, 30));
		MovimientosRealizados.setForeground(new Color(102, 51, 153));
		MovimientosRealizados.setHorizontalAlignment(SwingConstants.CENTER);
		MovimientosRealizados.setBounds(0, 441, 754, 69);
		MovimientosRealizados.setText("Movimientos realizados: " + Tablero.getMovimientos());
		frame.getContentPane().add(MovimientosRealizados);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
		
	public void botonVolverJugar() {
		JButton btnNewButton = new JButton("Volver a jugar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 0, 204));
		btnNewButton.setBounds(123, 516, 150, 33);
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
		JButton btnNewButton_1 = new JButton("Salir del juego");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(102, 0, 204));
		btnNewButton_1.setBounds(475, 516, 150, 33);
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
	lblNewLabel.setIcon(new ImageIcon(Win.class.getResource("/Imagenes/win.jpg")));
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
