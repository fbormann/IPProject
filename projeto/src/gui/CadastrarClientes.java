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
import excecoes.CPFInvalido;
import excecoes.CEPInvalido;
import negocios.CadastroConta;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollBar;

public class CadastrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_cpf;
	private CadastroConta contas;
	private RepositorioContasArray repositorioContas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(23, 68, 61, 16);
		contentPane.add(lblRua);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(23, 96, 61, 16);
		contentPane.add(lblNumero);

		JLabel lblComplemento = new JLabel("Comp.:");
		lblComplemento.setBounds(23, 125, 92, 16);
		contentPane.add(lblComplemento);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(23, 155, 61, 16);
		contentPane.add(lblCep);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(23, 189, 61, 16);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(23, 219, 61, 16);
		contentPane.add(lblCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(23, 247, 61, 16);
		contentPane.add(lblEstado);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 6, 15, 266);
		contentPane.add(scrollBar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 68, 86, 20);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(81, 96, 86, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 123, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 149, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(81, 183, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(81, 217, 86, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(81, 245, 86, 20);
		contentPane.add(textField_6);
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

	public boolean validadeCPF(String CPF) throws CPFInvalido{
		CPFInvalido e = new CPFInvalido(CPF);
		//checar tamanho da entrada
		if(CPF.length()!=14){
			throw e;
		}else{
			//checar as posicoes que devem ter numeros
			for(int i = 0; i<CPF.length(); i++){
				if(i!=3 && i!=7 && i!=11){
					if(CPF.charAt(i)>=48 && CPF.charAt(i)<=57){
						return true;
					} else {
						throw e;
					}
				}
			}
			//checar os pontos e o hifen
			String exemplo = "000.000.000-00";
			int a = exemplo.charAt(3);
			int b = exemplo.charAt(7);
			int c = exemplo.charAt(11);
			if(a == 46 && b == 46 && c == 45){
				return true;
			}else{
				throw e;
			}
		}
	}

	public boolean validadeCEP(String CEP) throws CEPInvalido{
		CEPInvalido e = new CEPInvalido(CEP);
		//checar tamanho
		if(CEP.length()!=9){
			throw e;
		}else{
			for(int i = 0; i<CEP.length(); i++){
				if(i!=5){
					if(CEP.charAt(i)>=48 && CEP.charAt(i)<=57){
						return true;
					}else{
						throw e;
					}
				}
			}
			String exemplo = "00000-000";
			int a = exemplo.charAt(5);
			if(a == 45){
				return true;
			}else{
				throw e;
			}
		}
	}

}
