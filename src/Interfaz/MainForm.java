package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

public class MainForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setForeground(Color.BLACK);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBackground(new Color(205, 133, 63));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_11 = new JButton("3");
		btnNewButton_11.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("4");
		btnNewButton_12.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_2 = new JButton("5");
		btnNewButton_2.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_10 = new JButton("7");
		btnNewButton_10.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_13 = new JButton("8");
		btnNewButton_13.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("10");
		btnNewButton_6.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_9 = new JButton("11");
		btnNewButton_9.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_14 = new JButton("12");
		btnNewButton_14.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_4 = new JButton("13");
		btnNewButton_4.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("14");
		btnNewButton_7.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("15");
		btnNewButton_8.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_15 = new JButton("");
		btnNewButton_15.setBackground(new Color(205, 133, 63));
		frame.getContentPane().add(btnNewButton_15);
	}
}
