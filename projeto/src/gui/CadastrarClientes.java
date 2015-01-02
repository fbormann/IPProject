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
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;

import dados.RepositorioContasArray;
import entidades.Conta;
import excecoes.ContaJaCadastrada;

import negocios.CadastroConta;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_cpf;
	private final JSeparator separator = new JSeparator();
	private CadastroConta contas;
	private RepositorioContasArray repositorioContas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarClientes frame = new CadastrarClientes();
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
	public CadastrarClientes() {
		repositorioContas = new RepositorioContasArray();
		contas = new CadastroConta(repositorioContas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 11, 46, 14);
		contentPane.add(lblNome);
		
		tf_name = new JTextField();
		tf_name.setBounds(81, 8, 86, 20);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(23, 42, 65, 14);
		contentPane.add(lblCpf);
		
		tf_cpf = new JTextField();
		tf_cpf.setBounds(81, 39, 86, 20);
		contentPane.add(tf_cpf);
		tf_cpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = tf_cpf.getText();
				String nome = tf_name.getText();
				Conta novaConta = new Conta();
				novaConta.setCPF(cpf);
				novaConta.setNome(nome);
				try {
					contas.cadastrar(novaConta);
				} catch (ContaJaCadastrada e1) {
					e1.getMessage(); //TODO: create popup to display message.
				}
			}
		});
		btnCadastrar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCadastrar);
		separator.setBounds(0, 67, 434, 31);
		contentPane.add(separator);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
