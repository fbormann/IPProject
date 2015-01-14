package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import comunicacao.OficinaFacade;
import entidades.Carro;
import entidades.Conta;
import entidades.Endereco;
import excecoes.CEPInvalidoException;

public class AtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tf_rua;
	private JTextField tf_numero;
	private JTextField tf_cep;
	private JTextField tf_bairro;
	private JTextField tf_cidade;
	private JTextField tf_estado;
	private JTextField tf_complemento;
	private JTextField tf_modelo;
	private JTextField tf_marca;
	private JTextField tf_cor;
	private JTextField tf_placa;
	private final JTextArea txtrCasoOEspao = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarCliente frame = new AtualizarCliente();
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
	public AtualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);

		JButton btn_atualizar = new JButton("Atualizar");

		btn_atualizar.setBounds(320, 228, 89, 23);
		panel.add(btn_atualizar);

		JLabel label_2 = new JLabel("Rua:");
		label_2.setBounds(23, 13, 61, 16);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Numero:");
		label_3.setBounds(177, 13, 61, 16);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Comp.:");
		label_4.setBounds(271, 13, 40, 16);
		panel.add(label_4);

		JLabel label_5 = new JLabel("CEP:");
		label_5.setBounds(23, 42, 61, 16);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Bairro:");
		label_6.setBounds(177, 42, 61, 16);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Cidade:");
		label_7.setBounds(23, 71, 61, 16);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Estado:");
		label_8.setBounds(177, 69, 40, 16);
		panel.add(label_8);

		tf_rua = new JTextField();
		tf_rua.setColumns(10);
		tf_rua.setBounds(81, 11, 86, 20);
		panel.add(tf_rua);

		tf_numero = new JTextField();
		tf_numero.setColumns(10);
		tf_numero.setBounds(221, 11, 40, 20);
		panel.add(tf_numero);

		tf_cep = new JTextField();
		tf_cep.setColumns(10);
		tf_cep.setBounds(81, 40, 86, 20);
		panel.add(tf_cep);

		tf_bairro = new JTextField();
		tf_bairro.setColumns(10);
		tf_bairro.setBounds(221, 40, 86, 20);
		panel.add(tf_bairro);

		tf_cidade = new JTextField();
		tf_cidade.setColumns(10);
		tf_cidade.setBounds(81, 69, 86, 20);
		panel.add(tf_cidade);

		tf_estado = new JTextField();
		tf_estado.setColumns(10);
		tf_estado.setBounds(221, 67, 86, 20);
		panel.add(tf_estado);

		tf_complemento = new JTextField();
		tf_complemento.setColumns(10);
		tf_complemento.setBounds(315, 11, 40, 20);
		panel.add(tf_complemento);

		JLabel lbl_modelo = new JLabel("Modelo:");
		lbl_modelo.setBounds(23, 101, 46, 14);
		panel.add(lbl_modelo);

		tf_modelo = new JTextField();
		tf_modelo.setColumns(10);
		tf_modelo.setBounds(81, 98, 86, 20);
		panel.add(tf_modelo);

		JLabel label_10 = new JLabel("Marca:");
		label_10.setBounds(177, 101, 46, 14);
		panel.add(label_10);

		tf_marca = new JTextField();
		tf_marca.setColumns(10);
		tf_marca.setBounds(221, 98, 86, 20);
		panel.add(tf_marca);

		JLabel label_11 = new JLabel("Cor:");
		label_11.setBounds(23, 146, 46, 14);
		panel.add(label_11);

		JLabel label_12 = new JLabel("Placa:");
		label_12.setBounds(177, 146, 46, 14);
		panel.add(label_12);

		tf_cor = new JTextField();
		tf_cor.setColumns(10);
		tf_cor.setBounds(81, 143, 86, 20);
		panel.add(tf_cor);

		tf_placa = new JTextField();
		tf_placa.setColumns(10);
		tf_placa.setBounds(221, 143, 86, 20);
		panel.add(tf_placa);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(4, 171, 257, 34);
		panel.add(lbl_error);
		txtrCasoOEspao.setLineWrap(true);
		txtrCasoOEspao.setText("Caso o espa\u00E7o seja deixado em branco, n\u00E3o consideraremos como parte da atualiza\u00E7\u00E3o");
		txtrCasoOEspao.setBounds(4, 205, 306, 57);
		panel.add(txtrCasoOEspao);

		btn_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				String cpf = tf_cpf.getText();
				//				String nome = tf_name.getText();
				//Criando o objeto Endereco.
				Endereco novoEndereco = new Endereco();
				novoEndereco.setBairro(tf_bairro.getText());
				novoEndereco.setCEP(tf_cep.getText());
				try {
					OficinaFacade.validadeCEP(novoEndereco.getCEP());
				} catch (CEPInvalidoException e1) {
					lbl_error.setText(e1.getMessage());
				}

				novoEndereco.setCidade(tf_cidade.getText());
				novoEndereco.setEstado(tf_estado.getText());
				novoEndereco.setRua(tf_rua.getText());
				novoEndereco.setComplemento(tf_complemento.getText());
				novoEndereco.setNumero(Integer.parseInt(tf_numero.getText()));

				Carro novoCarro = new Carro();
				novoCarro.setCor(tf_cor.getText());
				novoCarro.setMarca(tf_marca.getText());
				novoCarro.setModelo(tf_modelo.getText());
				novoCarro.setPlaca(tf_placa.getText());

				//Conta novaConta = new Conta(nome,cpf,novoEndereco,novoCarro);


			}
		});
	}
}
