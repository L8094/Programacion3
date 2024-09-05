package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;

public class Menu {

	private JFrame frame;
	private JTextField txtIngreseNombre;

	/**
	 * Launch the application.
	 */
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

	
	
	
	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(60, 60, 710, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnIngreseNombre = new JTextPane();
		txtpnIngreseNombre.setEditable(false);
		txtpnIngreseNombre.setText("ingrese nombre:");
		txtpnIngreseNombre.setBackground(Color.BLACK);
		txtpnIngreseNombre.setForeground(Color.WHITE);
		txtpnIngreseNombre.setToolTipText("");
		txtpnIngreseNombre.setBounds(136, 450, 99, 23);
		frame.getContentPane().add(txtpnIngreseNombre);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(199, 113, 297, 276);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtIngreseNombre = new JTextField();
		txtIngreseNombre.setForeground(Color.WHITE);
		txtIngreseNombre.setBackground(Color.GRAY);
		txtIngreseNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngreseNombre.setBounds(245, 450, 205, 20);
		frame.getContentPane().add(txtIngreseNombre);
		txtIngreseNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("comenzar");
		btnNewButton.setBounds(285, 481, 124, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-3, 0, 700, 561);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/fondo.jpg")));
		frame.getContentPane().add(lblNewLabel);
	}
}
