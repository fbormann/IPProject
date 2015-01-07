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
import entidades.Carro;
import entidades.Conta;
import entidades.Endereco;
import excecoes.PlacaInvalida;
import excecoes.ContaJaCadastradaException;
import excecoes.CPFInvalidoException;
import excecoes.CEPInvalidoException;
import negocios.ManagerConta;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollBar;

import comunicacao.Oficina;

public class CadastrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_cpf;
	private Oficina oficina;
	private JTextField tf_rua;
	private JTextField tf_numero;
	private JTextField tf_cep;
	private JTextField tf_bairro;
	private JTextField tf_cidade;
	private JTextField tf_estado;
	private JTextField tf_comp;
	private JTextField tf_modelo;
	private JTextField tf_marca;
	private JTextField tf_cor;
	private JTextField tf_placa;

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
	 * 
	 * 
	 */
	//TODO: criar construtor para testar a janela do cadastrar já preenchida com as informações do cliente (para poder editar) para não termos que fazer outra janela igual
	public CadastrarClientes() {
		oficina = new Oficina();
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
				//Criando o objeto Endereco.
				Endereco novoEndereco = new Endereco();
				novoEndereco.setBairro(tf_bairro.getText());
				novoEndereco.setCEP(tf_cep.getText());
				novoEndereco.setCidade(tf_cidade.getText());
				novoEndereco.setEstado(tf_estado.getText());
				novoEndereco.setRua(tf_rua.getText());
				novoEndereco.setComplemento(tf_comp.getText());
				novoEndereco.setNumero(Integer.parseInt(tf_numero.getText()));

				Carro novoCarro = new Carro();
				novoCarro.setCor(tf_cor.getText());
				novoCarro.setMarca(tf_marca.getText());
				novoCarro.setModelo(tf_modelo.getText());
				novoCarro.setPlaca(tf_placa.getText());

				Conta novaConta = new Conta(nome,cpf,novoEndereco,novoCarro);


				try{
					oficina.adicionarConta(novaConta);
					new Clientes().setVisible(true);
					fecharJFrame();
				}catch(ContaJaCadastradaException excep){
					//TODO: Aprender como utilizar popup ou mensagens de erro.
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

		tf_rua = new JTextField();
		tf_rua.setColumns(10);
		tf_rua.setBounds(81, 34, 86, 20);
		contentPane.add(tf_rua);

		tf_numero = new JTextField();
		tf_numero.setColumns(10);
		tf_numero.setBounds(221, 34, 40, 20);
		contentPane.add(tf_numero);

		tf_cep = new JTextField();
		tf_cep.setColumns(10);
		tf_cep.setBounds(81, 63, 86, 20);
		contentPane.add(tf_cep);

		tf_bairro = new JTextField();
		tf_bairro.setColumns(10);
		tf_bairro.setBounds(221, 63, 86, 20);
		contentPane.add(tf_bairro);

		tf_cidade = new JTextField();
		tf_cidade.setColumns(10);
		tf_cidade.setBounds(81, 92, 86, 20);
		contentPane.add(tf_cidade);

		tf_estado = new JTextField();
		tf_estado.setColumns(10);
		tf_estado.setBounds(221, 90, 86, 20);
		contentPane.add(tf_estado);

		tf_comp = new JTextField();
		tf_comp.setColumns(10);
		tf_comp.setBounds(315, 34, 40, 20);
		contentPane.add(tf_comp);

		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setBounds(23, 147, 46, 14);
		contentPane.add(lblNewLabel);

		tf_modelo = new JTextField();
		tf_modelo.setColumns(10);
		tf_modelo.setBounds(81, 144, 86, 20);
		contentPane.add(tf_modelo);

		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(177, 147, 46, 14);
		contentPane.add(lblNewLabel_1);

		tf_marca = new JTextField();
		tf_marca.setColumns(10);
		tf_marca.setBounds(221, 144, 86, 20);
		contentPane.add(tf_marca);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(23, 192, 46, 14);
		contentPane.add(lblCor);

		JLabel lblNewLabel_2 = new JLabel("Placa:");
		lblNewLabel_2.setBounds(177, 192, 46, 14);
		contentPane.add(lblNewLabel_2);

		tf_cor = new JTextField();
		tf_cor.setColumns(10);
		tf_cor.setBounds(81, 189, 86, 20);
		contentPane.add(tf_cor);

		tf_placa = new JTextField();
		tf_placa.setColumns(10);
		tf_placa.setBounds(221, 189, 86, 20);
		contentPane.add(tf_placa);
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

	public void fecharJFrame(){
		this.dispose();
	}


}


