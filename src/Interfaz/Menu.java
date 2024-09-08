package Interfaz;

import javax.swing.Timer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Menu {

	private JFrame frame;
	private JTextField ingreso;
	private static String nombre;
	
	private int direccion = 1;  
    private int ejeXRompecabezas = 226; 
    private int ejeXDeslizante = 254;   
    

//-----------------------------------------------------------------------------------------------------------------------------------
    
    public void titulo() {
			
			JButton btnNewButton = new JButton("Comenzar el juego");
			btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					nombre += ingreso.getText();
					frame.setVisible(false);
					Juego.main(null);
				}
			});
			ingreso = new JTextField();
			ingreso.setFont(new Font("Tahoma", Font.BOLD, 18));
			ingreso.setForeground(Color.WHITE);
			ingreso.setBackground(new Color(106, 90, 205));
			ingreso.setHorizontalAlignment(SwingConstants.CENTER);
			ingreso.setBounds(210, 460, 306, 51);
			frame.getContentPane().add(ingreso);
			ingreso.setColumns(10);
			
			ingreso.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Acción al presionar "Enter"
	            nombre += ingreso.getText();
	            frame.setVisible(false);
	            Juego.main(null);
	        }
	    });
			
			btnNewButton.setBounds(261, 544, 205, 35);
			frame.getContentPane().add(btnNewButton);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 26));
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setBounds(265, 420, 197, 38);
				frame.getContentPane().add(lblNewLabel_1);
			}


			JLabel lblRompecabezas = new JLabel("Rompecabezas");
			lblRompecabezas.setHorizontalAlignment(SwingConstants.CENTER);
			lblRompecabezas.setForeground(new Color(255, 255, 255));
			lblRompecabezas.setFont(new Font("Asember Ligature Demo", Font.PLAIN, 40));
			lblRompecabezas.setBounds(-14, -79, 754, 701);
			frame.getContentPane().add(lblRompecabezas);
		
			JLabel labelDselizante= new JLabel("Deslizante");
			labelDselizante.setHorizontalAlignment(SwingConstants.CENTER);
			labelDselizante.setForeground(Color.WHITE);
			labelDselizante.setFont(new Font("Asember Ligature Demo", Font.PLAIN, 25));
			labelDselizante.setBounds(0, -11, 754, 701);
			frame.getContentPane().add(labelDselizante);
		
    
		
		 Timer timer = new Timer(10, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ejeXRompecabezas -= direccion;
	            	ejeXDeslizante += direccion;
	                
	            	lblRompecabezas.setBounds(ejeXRompecabezas, 200, 500, 98);
	                labelDselizante.setBounds(ejeXDeslizante, 280, 247, 98);
	                if (ejeXRompecabezas <= 0 || ejeXRompecabezas >= frame.getWidth() - 500) {
	                    direccion *= -1;
	                }
	            }
	        });
	        timer.start();
	    }
        
	
//-----------------------------------------------------------------------------------------------------------------------------------	
	
	public void cartelIngreseNombre() {	
}
	
//-----------------------------------------------------------------------------------------------------------------------------------
		
	public void ingresoNombre() {
		
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	public void botonComenzar() {
	
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
		frame.setTitle("Menu Principal");
		
		nombre= "";
		
		titulo();
		
		cartelIngreseNombre();
		
		ingresoNombre();
	
		botonComenzar();
		
		cargarFondo();	
	}
}
