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

import javax.swing.JRadioButton;

import comunicacao.OficinaFacade;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;
import excecoes.ServicoJaCadastradoException;
import excecoes.TipoNaoSelecionadoException;
import excecoes.TiposSelecionadosException;

import javax.swing.JCheckBox;

import java.awt.Color;

public class CadastrarServico extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_preco;
	private JTextField tf_nome;

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

		JLabel lblId = new JLabel("C\u00F3digo:");
		lblId.setBounds(10, 47, 58, 14);
		contentPane.add(lblId);

		tf_id = new JTextField();
		tf_id.setBounds(66, 44, 86, 20);
		contentPane.add(tf_id);
		tf_id.setColumns(10);

		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 78, 46, 14);
		contentPane.add(lblPreco);

		tf_preco = new JTextField();
		tf_preco.setBounds(66, 75, 86, 20);
		contentPane.add(tf_preco);
		tf_preco.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(335, 187, 89, 23);
		contentPane.add(btnCadastrar);

		tf_nome = new JTextField();
		tf_nome.setColumns(10);
		tf_nome.setBounds(66, 8, 166, 20);
		contentPane.add(tf_nome);

		final JRadioButton rdbtn_lavagem = new JRadioButton("Lavagem");
		rdbtn_lavagem.setBounds(31, 120, 109, 23);
		contentPane.add(rdbtn_lavagem);

		final JRadioButton rdbtn_otimizacao = new JRadioButton("Otimiza\u00E7\u00E3o");
		rdbtn_otimizacao.setBounds(156, 120, 109, 23);
		contentPane.add(rdbtn_otimizacao);

		final JRadioButton rdbtn_produto = new JRadioButton("Produto");
		rdbtn_produto.setBounds(292, 120, 109, 23);
		contentPane.add(rdbtn_produto);

		final JLabel label_error = new JLabel("");
		label_error.setForeground(Color.RED);
		label_error.setBounds(41, 223, 178, 16);
		contentPane.add(label_error);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Oficina().setVisible(true);
				fecharJFrame();
			}
		});
		btnVoltar.setBounds(315, 32, 117, 29);
		contentPane.add(btnVoltar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tf_nome.getText();
				String codigo = tf_id.getText();
				String preco = tf_preco.getText();
				Servico novoServico = null;

				try {
					checkbox(rdbtn_lavagem.isSelected(),rdbtn_otimizacao.isSelected(),rdbtn_produto.isSelected());
					if(rdbtn_lavagem.isSelected()){ 
						novoServico = new Lavagem(nome, Double.parseDouble(preco),codigo);
					}else if(rdbtn_otimizacao.isSelected()){
						novoServico =  new Otimizacao(nome, Double.parseDouble(preco),codigo);
					}else if(rdbtn_produto.isSelected()){
						novoServico = new Produto(nome, Double.parseDouble(preco),codigo); 
					}
					try {
						OficinaFacade.adicionarServico(novoServico);
						new ServicoGUI().setVisible(true);
						fecharJFrame();
					} catch (ServicoJaCadastradoException e1) {
						label_error.setText(e1.getMessage());
					} catch (TipoNaoSelecionadoException e2){
						label_error.setText(e2.getMessage());
					}
				} catch (TiposSelecionadosException e2) {
					label_error.setText(e2.getMessage());
					e2.printStackTrace();
				}

			}

		});

	}

	//metodo que vai checar se mais de um botao de tipo de servico foi selecionado
	public void checkbox(boolean rdbtn_lavagem, boolean rdbtn_otimizacao, boolean rdbtn_produto) throws TiposSelecionadosException{
		TiposSelecionadosException e = new TiposSelecionadosException();
		if(rdbtn_lavagem && rdbtn_otimizacao){
			throw e;
		}else if(rdbtn_lavagem && rdbtn_produto){
			throw e;
		}else if(rdbtn_produto && rdbtn_otimizacao){
			throw e;
		}else if(rdbtn_produto && rdbtn_otimizacao && rdbtn_lavagem){
			throw e;
		}
	}
	public void fecharJFrame() {
		this.dispose();
	}
}
