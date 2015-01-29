package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import comunicacao.OficinaFacade;
import entidades.Compra;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;
import excecoes.CompraNaoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarCompra extends JFrame {

	private JPanel contentPane;

	private JTextField tf_compraCPF;
	private JTextField tf_ID;
	private JTextField tf_valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarCompra frame = new AtualizarCompra();
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
	public AtualizarCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_compraCPF = new JTextField();
		tf_compraCPF.setEditable(false);
		tf_compraCPF.setColumns(10);
		tf_compraCPF.setBounds(76, 6, 166, 20);
		contentPane.add(tf_compraCPF);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(6, 8, 61, 16);
		contentPane.add(lblCpf);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(6, 40, 61, 16);
		contentPane.add(lblId);

		tf_ID = new JTextField();
		tf_ID.setEditable(false);
		tf_ID.setColumns(10);
		tf_ID.setBounds(76, 38, 166, 20);
		contentPane.add(tf_ID);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(6, 71, 61, 16);
		contentPane.add(lblValor);

		tf_valor = new JTextField();
		tf_valor.setColumns(10);
		tf_valor.setBounds(76, 70, 166, 20);
		contentPane.add(tf_valor);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Compras().setVisible(true);
				fecharJFrame();
			}
		});
		btnVoltar.setBounds(294, 216, 117, 29);
		contentPane.add(btnVoltar);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setBounds(45, 172, 208, 16);
		contentPane.add(lbl_error);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra novaCompra = new Compra();
				novaCompra.setValor(Double.parseDouble(tf_valor.getText()));
				novaCompra.setContaCPF(tf_compraCPF.getText());
				novaCompra.setId(tf_ID.getText());
				try {
					OficinaFacade.updateCompra(novaCompra);
				} catch (CompraNaoExisteException e1) {
					lbl_error.setText(e1.getMessage());
					e1.printStackTrace();
				}
				new Compras().setVisible(true);
			}
		});
		btnAtualizar.setBounds(259, 105, 117, 29);
		contentPane.add(btnAtualizar);
	}

	public void fecharJFrame(){
		this.dispose();
	}

	public void selecionarDados(Compra compra){

		tf_valor.setText(String.valueOf(compra.getValor()));
		tf_ID.setText(compra.getId());
		tf_compraCPF.setText(compra.getContaCPF());
	}
}
