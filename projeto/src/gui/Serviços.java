package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Serviços extends JFrame {

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
					Serviços frame = new Serviços();
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
	public Serviços() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(26, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(163, 6, 117, 29);
		contentPane.add(btnListar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(310, 6, 117, 29);
		contentPane.add(btnRemover);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(327, 243, 117, 29);
		contentPane.add(btnProcurar);
		
		textField = new JTextField();
		textField.setBounds(181, 242, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
