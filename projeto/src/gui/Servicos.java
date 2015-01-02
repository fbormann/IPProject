package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Servicos extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnListar;
	private JButton btnRemover;
	private JButton btnProcurar;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos frame = new Servicos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(26, 6, 117, 29);
		contentPane.add(btnNewButton);
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnListar.setBounds(163, 6, 117, 29);
		contentPane.add(btnListar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(310, 6, 117, 29);
		contentPane.add(btnRemover);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(325, 250, 117, 20);
		contentPane.add(btnProcurar);
		
		textField = new JTextField();
		textField.setBounds(181, 250, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
	
}
