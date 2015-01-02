package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(20, 6, 117, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(327, 243, 117, 29);
		contentPane.add(btnProcurar);
		
		textField = new JTextField();
		textField.setBounds(181, 242, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(170, 6, 117, 29);
		contentPane.add(btnListar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(308, 6, 117, 29);
		contentPane.add(btnRemover);
	}
}