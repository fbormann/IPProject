package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
<<<<<<< HEAD
=======
import javax.swing.JLabel;
import javax.swing.JButton;

import comunicacao.OficinaFacade;
import entidades.Compra;
import excecoes.CompraNaoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> 01546120dfb5ad71dedd28e50e8fa52d4aa34cf4

public class AtualizarCompra extends JFrame {

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
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

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(76, 6, 166, 20);
		contentPane.add(textField);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(6, 8, 61, 16);
		contentPane.add(lblCpf);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(6, 40, 61, 16);
		contentPane.add(lblId);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(76, 38, 166, 20);
		contentPane.add(textField_1);

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
				try {
					OficinaFacade.updateCompra(novaCompra);
				} catch (CompraNaoExisteException e1) {
					lbl_error.setText(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(259, 105, 117, 29);
		contentPane.add(btnAtualizar);
	}

	public void fecharJFrame(){
		this.dispose();
	}
}
