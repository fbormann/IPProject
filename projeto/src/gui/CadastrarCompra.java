package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import negocios.ManagerServico;
import comunicacao.OficinaFacade;
import dados.RepositorioServicoArray;
import entidades.Compra;
import entidades.Conta;
import entidades.Servico;
import excecoes.CPFInvalidoException;
import excecoes.ContaNaoExisteException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Iterator;

public class CadastrarCompra extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nome;
	private JTextField tf_CPF;
	private JTextField tf_valorapagar;
	private double preco;
	private JTextField tf_compraID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCompra frame = new CadastrarCompra();
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
	public CadastrarCompra() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JList list_disponiveis = new JList();
		list_disponiveis.setBounds(27, 88, 173, 229);

		final DefaultListModel model_Disponiveis = new DefaultListModel(); 
		for(Iterator<Servico> itr = OficinaFacade.servicoIterator();itr.hasNext();){
			Servico servico =  (Servico)itr.next();
			model_Disponiveis.addElement(servico.getNome() + "[" + servico.getID() +"]" + " " + servico.getPreco() );
		}

		list_disponiveis.setModel(model_Disponiveis);
		contentPane.add(list_disponiveis);

		JLabel lblListaDeServios = new JLabel("Lista de Servi\u00E7os Dispon\u00EDveis");
		lblListaDeServios.setBounds(27, 53, 173, 24);
		contentPane.add(lblListaDeServios);

		final JList list_comprados = new JList();
		list_comprados.setBounds(253, 88, 173, 229); 
		final DefaultListModel model_Comprados = new DefaultListModel(); //Lista de Servicos comprados.
		list_comprados.setModel(model_Comprados);
		contentPane.add(list_comprados);

		JLabel lblListaDeServios_1 = new JLabel("Lista de Servi\u00E7os Comprados");
		lblListaDeServios_1.setBounds(253, 53, 173, 24);
		contentPane.add(lblListaDeServios_1);

		JButton btnFinalizarCompra = new JButton("Finalizar Compra");

		btnFinalizarCompra.setBounds(290, 375, 136, 23);
		contentPane.add(btnFinalizarCompra);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Compras().setVisible(true);
				fecharJFrame();
			}
		});
		btnVoltar.setBounds(337, 0, 89, 23);
		contentPane.add(btnVoltar);

		final JLabel lblNomeDoComprador = new JLabel("Nome do Comprador");
		lblNomeDoComprador.setBounds(28, 28, 104, 14);
		contentPane.add(lblNomeDoComprador);

		tf_nome = new JTextField();
		tf_nome.setEditable(false);
		tf_nome.setBounds(142, 25, 161, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);

		JLabel lblCpfDoComprador = new JLabel("CPF do Comprador");
		lblCpfDoComprador.setBounds(27, 4, 105, 14);
		contentPane.add(lblCpfDoComprador);

		tf_CPF = new JTextField();

		tf_CPF.setBounds(142, 1, 161, 20);
		contentPane.add(tf_CPF);
		tf_CPF.setColumns(10);

		JLabel lblValorPagar = new JLabel("Valor \u00E0 Pagar:");
		lblValorPagar.setBounds(27, 388, 105, 14);
		contentPane.add(lblValorPagar);

		tf_valorapagar = new JTextField();
		tf_valorapagar.setEditable(false);
		tf_valorapagar.setColumns(10);
		tf_valorapagar.setBounds(128, 385, 104, 20);
		contentPane.add(tf_valorapagar);

		JButton btnAdicionarLista = new JButton("Adicionar \u00E0 Lista");
		btnAdicionarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_disponiveis.getSelectedValue() != null){
					String ID = list_disponiveis.getSelectedValue().toString().substring(list_disponiveis.getSelectedValue().toString().indexOf("[", 0)+1,list_disponiveis.getSelectedValue().toString().lastIndexOf("]"));
					try {
						Servico aux = OficinaFacade.buscarServico(ID);
						model_Comprados.addElement(aux.getNome() + "[" + aux.getID() +"]" + " " + aux.getPreco()); //String formatada para apresenter o nome, o ID e o preco dos Servicos
						preco += aux.getPreco();//Atualiza o preco da compra.
						tf_valorapagar.setText(String.valueOf(preco));//Seta o preco na GUI.
					} catch (ServicoNaoEncontradoException e1) {

					} 
				}else{
				}

			}
		});
		btnAdicionarLista.setBounds(27, 325, 126, 23);
		contentPane.add(btnAdicionarLista);

		JButton btnRemoverDaLista = new JButton("Remover da Lista");
		btnRemoverDaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = list_comprados.getSelectedIndex();//Pega o indice do elemento selecionado e o deleta.
				String ID = list_comprados.getSelectedValue().toString().substring(list_comprados.getSelectedValue().toString().indexOf("[", 0)+1,list_comprados.getSelectedValue().toString().lastIndexOf("]")); //Retorna o ID de cada servico.
				try {
					preco -= OficinaFacade.buscarServico(ID).getPreco();
					tf_valorapagar.setText(String.valueOf(preco));
				} catch (ServicoNaoEncontradoException e1) {
					e1.printStackTrace();
				}
				model_Comprados.remove(index);

			}
		});
		btnRemoverDaLista.setBounds(253, 328, 126, 23);
		contentPane.add(btnRemoverDaLista);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setBounds(27, 417, 399, 16);
		contentPane.add(lbl_error);

		JLabel lblId = new JLabel("ID da compra:");
		lblId.setBounds(27, 360, 116, 16);
		contentPane.add(lblId);

		tf_compraID = new JTextField();
		tf_compraID.setColumns(10);
		tf_compraID.setBounds(128, 356, 104, 20);
		contentPane.add(tf_compraID);

		tf_CPF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				try {
					String nome = OficinaFacade.buscarConta(tf_CPF.getText()).getNome();
					tf_nome.setText(nome);
					lbl_error.setText("CPF OK");
				} catch (ContaNaoExisteException e1) {
					lbl_error.setText(e1.getMessage());
				} catch (CPFInvalidoException e1) {
					lbl_error.setText(e1.getMessage());
				}
			}
		});

		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				Servico[] comprados = new Servico[0]; //Array de todos os Servicos Comprados.
				for(int i = 0; i < model_Comprados.getSize();i++){
					String ID = model_Comprados.get(i).toString().substring(model_Comprados.get(i).toString().indexOf("[", 0)+1,model_Comprados.get(i).toString().lastIndexOf("]"));
					try {
						Servico[] aux = new Servico[comprados.length+1];
						for(int j = 0; j < comprados.length;j++){
							aux[j] =  comprados[j];
						}
						if(aux == null){
							aux[0] = OficinaFacade.buscarServico(ID);
						}else{
							aux[aux.length-1] = OficinaFacade.buscarServico(ID);
						}
						comprados = aux;
					} catch (ServicoNaoEncontradoException e1) {
						e1.printStackTrace();
					}

				}
				Compra novaCompra = new Compra();

				novaCompra.setId(tf_compraID.getText());
				novaCompra.setContaCPF(tf_CPF.getText());
				novaCompra.setServicos(comprados);
				novaCompra.setValor(preco);

				if(tf_compraID.getText().equals("")){
					lbl_error.setText("ID da compra nao pode ser algo vazio");
				}else{
					OficinaFacade.adicionarCompra(novaCompra);
					new Compras().setVisible(true);
					fecharJFrame();
				}

			}
		});
	}

	protected void fecharJFrame() {
		this.dispose();

	}
}
