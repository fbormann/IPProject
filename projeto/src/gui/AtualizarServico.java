package gui;

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
	private JTextField tf_codigo;
	private JTextField tf_preco;
	private JTextField tf_nome;
	private String ID;
	private int tipoServico;

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

		tf_codigo = new JTextField();
		tf_codigo.setEditable(false);
		tf_codigo.setColumns(10);
		tf_codigo.setBounds(66, 44, 86, 20);
		panel.add(tf_codigo);

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
				Servico servicoAtualizado = null;
				switch(tipoServico){
				case 1:
					servicoAtualizado = new Lavagem();
					break;
				case 2:
					servicoAtualizado = new Otimizacao();
					break;
				case 3:
					servicoAtualizado = new Produto();
					break;
				}
				servicoAtualizado.setNome(tf_nome.getText());

				servicoAtualizado.setPreco(Double.parseDouble(tf_preco.getText()));

				try {
					OficinaFacade.updateServico(servicoAtualizado);
					new ServicoGUI().setVisible(true);
					fecharJFrame();
				} catch (ServicoNaoEncontradoException e1) {
					lbl_error.setText(e1.getMessage());
					e1.printStackTrace();
				}
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

	public void selecionarDados(Servico servico){
		if(servico instanceof Lavagem){
			this.tipoServico = 1;
		}else if(servico instanceof Otimizacao){
			this.tipoServico = 2;
		}else if(servico instanceof Produto){
			this.tipoServico = 3;
		}
		tf_nome.setText(servico.getNome());
		tf_codigo.setText(servico.getID());
		tf_preco.setText(String.valueOf(servico.getPreco()));
	}




}
