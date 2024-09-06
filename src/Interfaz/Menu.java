package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField ingreso;
	private static String nombre;
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void cartelIngreseNombre() {	
		JTextPane txtpnIngreseNombre = new JTextPane();
		txtpnIngreseNombre.setEditable(false);
		txtpnIngreseNombre.setText("ingrese nombre:");
		txtpnIngreseNombre.setBackground(Color.BLACK);
		txtpnIngreseNombre.setForeground(Color.WHITE);
		txtpnIngreseNombre.setToolTipText("");
		txtpnIngreseNombre.setBounds(171, 524, 99, 23);
		frame.getContentPane().add(txtpnIngreseNombre);
}
	
//-----------------------------------------------------------------------------------------------------------------------------------
		
	public void ingresoNombre() {
		ingreso = new JTextField();
		ingreso.setForeground(Color.WHITE);
		ingreso.setBackground(Color.GRAY);
		ingreso.setHorizontalAlignment(SwingConstants.CENTER);
		ingreso.setBounds(280, 524, 205, 20);
		frame.getContentPane().add(ingreso);
		ingreso.setColumns(10);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	public void botonComenzar() {
	JButton btnNewButton = new JButton("comenzar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nombre += ingreso.getText();
			frame.setVisible(false);
			Juego.main(null);
		}
	});
	btnNewButton.setBounds(319, 573, 124, 23);
	frame.getContentPane().add(btnNewButton);
}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	private void cargarFondo() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 11, 700, 675);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/fondo.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
	}

//-----------------------------------------------------------------------------------------------------------------------------------
		
	public static String getNombre() {
		return nombre;
	}	
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Menu() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(60, 20, 770, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nombre= "";
		
		cartelIngreseNombre();
		
		ingresoNombre();
	
		botonComenzar();
		
		cargarFondo();	
	}
}
