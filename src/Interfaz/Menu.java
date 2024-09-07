package Interfaz;

import javax.swing.Timer;
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
import java.awt.Font;

public class Menu {

	private JFrame frame;
	private JTextField ingreso;
	private static String nombre;
	
	private int direccion = 1;  // 1 para mover hacia la derecha, -1 para mover hacia la izquierda
    private int ejeXRompecabezas = 226; // Posición inicial en x de la etiqueta "Rompecabezas"
    private int ejeXDeslizante = 254;   // Posición inicial en x de la etiqueta "Deslizante"


    
    public void titulo() {

			JLabel lblRompecabezas = new JLabel("Rompecabezas");
			lblRompecabezas.setHorizontalAlignment(SwingConstants.CENTER);
			lblRompecabezas.setForeground(new Color(255, 255, 255));
			lblRompecabezas.setFont(new Font("Asember Ligature Demo", Font.PLAIN, 40));
			lblRompecabezas.setBounds(0, 0, 754, 701);
			frame.getContentPane().add(lblRompecabezas);
		
			JLabel labelDselizante= new JLabel("Deslizante");
			labelDselizante.setHorizontalAlignment(SwingConstants.CENTER);
			labelDselizante.setForeground(Color.WHITE);
			labelDselizante.setFont(new Font("Asember Ligature Demo", Font.PLAIN, 25));
			labelDselizante.setBounds(10, 68, 754, 701);
			frame.getContentPane().add(labelDselizante);
		
    
		
		 Timer timer = new Timer(10, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ejeXRompecabezas -= direccion;
	            	ejeXDeslizante += direccion;
	                
	            	
	            	//Actualizar las posiciones
	            	lblRompecabezas.setBounds(ejeXRompecabezas, 300, 500, 98);
	                labelDselizante.setBounds(ejeXDeslizante, 380, 247, 98);

	                //Si llega al borde cambia de direccion
	                if (ejeXRompecabezas <= 0 || ejeXRompecabezas >= frame.getWidth() - 500) {
	                    direccion *= -1;
	                }
	            }
	        });
	        timer.start();
	    }
    
		
    
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void cartelIngreseNombre() {	

		JTextPane txtpnIngreseNombre = new JTextPane();
		txtpnIngreseNombre.setEditable(false);
		txtpnIngreseNombre.setText("Ingrese nombre:");
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
		
		JButton btnNewButton = new JButton("Comenzar el juego");
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre += ingreso.getText();
				frame.setVisible(false);
				Juego.main(null);
			}
		});
		btnNewButton.setBounds(280, 573, 205, 35);
		frame.getContentPane().add(btnNewButton);
	
}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	private void cargarFondo() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 754, 701);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/fondoMenu.jpg")));
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
		
		titulo();
		
		cartelIngreseNombre();
		
		ingresoNombre();
	
		botonComenzar();
		
		cargarFondo();	
	}
}
