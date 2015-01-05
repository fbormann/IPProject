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

import excecoes.PlacaInvalida;
import excecoes.ContaJaCadastradaException;
import excecoes.CPFInvalidoException;
import excecoes.CEPInvalidoException;

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
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		lblCpf.setBounds(177, 11, 65, 14);
		contentPane.add(lblCpf);

		tf_cpf = new JTextField();
		tf_cpf.setBounds(221, 8, 86, 20);
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
				} catch (ContaJaCadastradaException e1) {
					e1.getMessage(); //TODO: create popup to display message.
				}
			}
		});
		btnCadastrar.setBounds(320, 228, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(23, 36, 61, 16);
		contentPane.add(lblRua);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(177, 36, 61, 16);
		contentPane.add(lblNumero);

		JLabel lblComplemento = new JLabel("Comp.:");
		lblComplemento.setBounds(271, 36, 40, 16);
		contentPane.add(lblComplemento);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(23, 65, 61, 16);
		contentPane.add(lblCep);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(177, 65, 61, 16);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(23, 94, 61, 16);
		contentPane.add(lblCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(177, 92, 40, 16);
		contentPane.add(lblEstado);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 34, 86, 20);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 34, 40, 20);
		contentPane.add(textField_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 63, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(221, 63, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(81, 92, 86, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(221, 90, 86, 20);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(315, 34, 40, 20);
		contentPane.add(textField_7);

		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setBounds(23, 147, 46, 14);
		contentPane.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 144, 86, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(177, 147, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(221, 144, 86, 20);
		contentPane.add(textField_8);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(23, 192, 46, 14);
		contentPane.add(lblCor);

		JLabel lblNewLabel_2 = new JLabel("Placa:");
		lblNewLabel_2.setBounds(177, 192, 46, 14);
		contentPane.add(lblNewLabel_2);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(81, 189, 86, 20);
		contentPane.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(221, 189, 86, 20);
		contentPane.add(textField_10);
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

	public boolean validadeCPF(String CPF) throws CPFInvalidoException{
		CPFInvalidoException e = new CPFInvalidoException(CPF);
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
			String exemploCPF = "000.000.000-00";
			int a = exemploCPF.charAt(3);
			int b = exemploCPF.charAt(7);
			int c = exemploCPF.charAt(11);
			if(a == 46 && b == 46 && c == 45){
				return true;
			}else{
				throw e;
			}
		}
	}

	public boolean validadeCEP(String CEP) throws CEPInvalidoException{
		CEPInvalidoException e = new CEPInvalidoException(CEP);
		//checar tamanho
		if(CEP.length()!=9){
			throw e;
			//checando se há somente números
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
			//checando ap
			String exemploCEP = "00000-000";
			int a = exemploCEP.charAt(5);
			if(a == 45){
				return true;
			}else{
				throw e;
			}
		}
	}

	public boolean validadePlaca(String placa) throws PlacaInvalida{
		PlacaInvalida a = new PlacaInvalida(placa);
		//checar tamanho
		if(placa.length()!=8){
			throw a;
			//checando se há numeros onde deve haver números
		}else{
			for(int i = 0; i <placa.length(); i++){
				if(i>=4){
					if(placa.charAt(i)>=48 && placa.charAt(i)<=57){
						return true;
					}else{
						throw a;
					}
				}
				//checando se há letras onde deve haver letras
				if(i<=2){
					if(placa.charAt(i)>=65 && placa.charAt(i)<=90){
						return true;
					}else{
						throw a;
					}
				}
			}
			//checando se o hifen está na posicao correta
			String exemploPlaca = "AAA-0000";
			int c = exemploPlaca.charAt(3);
			if(c == 45){
				return true;
			}else{
				throw a;
			}

		}
	}
}
