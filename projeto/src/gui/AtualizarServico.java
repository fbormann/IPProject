package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import comunicacao.OficinaFacade;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;
import excecoes.ServicoNaoEncontradoException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarServico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tf_preco;
	private JTextField tf_nome;
	private String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarServico frame = new AtualizarServico();
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
	public AtualizarServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 450, 278);
		contentPane.add(panel);

		JLabel label_nome = new JLabel("Nome:");
		label_nome.setBounds(10, 11, 46, 14);
		panel.add(label_nome);

		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setBounds(10, 47, 58, 14);
		panel.add(label_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(66, 44, 86, 20);
		panel.add(textField);

		JLabel label_preco = new JLabel("Pre\u00E7o:");
		label_preco.setBounds(10, 78, 46, 14);
		panel.add(label_preco);

		tf_preco = new JTextField();
		tf_preco.setColumns(10);
		tf_preco.setBounds(66, 75, 86, 20);
		panel.add(tf_preco);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(41, 194, 191, 16);
		panel.add(lbl_error);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lavagem novaLavagem = new Lavagem();
				Otimizacao novaOtimizacao = new Otimizacao();
				Produto novoProduto = new Produto();
				
				if(novaLavagem instanceof Servico){
					if(!tf_nome.getText().equals("")){
						((Servico) novaLavagem).setNome(tf_nome.getText());
					}
					if(!tf_preco.getText().equals("")){
						((Servico) novaLavagem).setPreco(Double.parseDouble(tf_preco.getText()));
					}

					try {
						OficinaFacade.updateServico(novaLavagem);
					} catch (ServicoNaoEncontradoException e1) {
						lbl_error.setText(e1.getMessage());
						e1.printStackTrace();
					}

				}else if(novaOtimizacao instanceof Servico){
					if(!tf_nome.getText().equals("")){
						((Servico) novaOtimizacao).setNome(tf_nome.getText());
					}
					if(!tf_preco.getText().equals("")){
						((Servico) novaOtimizacao).setPreco(Double.parseDouble(tf_preco.getText()));
					}

					try {
						OficinaFacade.updateServico(novaOtimizacao);
					} catch (ServicoNaoEncontradoException e1) {
						lbl_error.setText(e1.getMessage());
						e1.printStackTrace();
					}

				}else if(novoProduto instanceof Servico){
					if(!tf_nome.getText().equals("")){
						((Servico) novoProduto).setNome(tf_nome.getText());
					}
					if(!tf_preco.getText().equals("")){
						((Servico) novoProduto).setPreco(Double.parseDouble(tf_preco.getText()));
					}

					try {
						OficinaFacade.updateServico(novoProduto);
					} catch (ServicoNaoEncontradoException e1) {
						lbl_error.setText(e1.getMessage());
						e1.printStackTrace();
					}
				}
				new ServicoGUI().setVisible(true);
				fecharJFrame();
			}
		});
		btnAtualizar.setBounds(335, 187, 89, 23);
		panel.add(btnAtualizar);

		tf_nome = new JTextField();
		tf_nome.setColumns(10);
		tf_nome.setBounds(66, 8, 166, 20);
		panel.add(tf_nome);

		JRadioButton radioButton = new JRadioButton("Lavagem");
		radioButton.setEnabled(false);
		radioButton.setBounds(31, 120, 109, 23);
		panel.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Otimiza\u00E7\u00E3o");
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(156, 120, 109, 23);
		panel.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Produto");
		radioButton_2.setEnabled(false);
		radioButton_2.setBounds(292, 120, 109, 23);
		panel.add(radioButton_2);

		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setBounds(41, 223, 178, 16);
		panel.add(label_3);

		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ServicoGUI().setVisible(true);
				fecharJFrame();
			}
		});
		button_1.setBounds(315, 32, 117, 29);
		panel.add(button_1);

	}

	public void fecharJFrame(){
		this.dispose();
	}
}