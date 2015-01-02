package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarServico extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nome;
	private JTextField tf_id;
	private JTextField tf_preco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarServico frame = new CadastrarServico();
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
	public CadastrarServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		tf_nome = new JTextField();
		tf_nome.setBounds(66, 8, 86, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 47, 46, 14);
		contentPane.add(lblId);
		
		tf_id = new JTextField();
		tf_id.setBounds(66, 44, 86, 20);
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 91, 46, 14);
		contentPane.add(lblPreco);
		
		tf_preco = new JTextField();
		tf_preco.setBounds(66, 88, 86, 20);
		contentPane.add(tf_preco);
		tf_preco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCadastrar);
	}

}
