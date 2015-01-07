package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
=======
>>>>>>> d2f3a5081ae09c0ae4a73a124cf20501556ea765

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(103, 11, 46, 14);
		contentPane.add(lblClientes);
		
		table = new JTable();
		table.setBounds(25, 36, 219, 204);
		contentPane.add(table);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(294, 121, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(294, 186, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(294, 56, 89, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarClientes().setVisible(true);
				fecharJFrame();
			}
		});
		btnCadastrar.setBounds(294, 56, 89, 23);
		contentPane.add(btnCadastrar);
		
		
	}
	
	public void listarClientes(){
		
	}
	
	public void fecharJFrame(){
		this.dispose();

	}
}
