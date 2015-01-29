package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JList;

import java.awt.Color;

import javax.swing.JButton;

import comunicacao.OficinaFacade;
import entidades.Compra;
import entidades.Conta;
import excecoes.CPFInvalidoException;
import excecoes.CompraNaoExisteException;
import excecoes.ContaNaoExisteException;
import excecoes.ServicoNaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JLabel;

public class Compras extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
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
	public Compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_Cadastrar = new JButton("Cadastrar");

		btn_Cadastrar.setBounds(311, 47, 89, 23);
		contentPane.add(btn_Cadastrar);

		JButton btn_Remover = new JButton("Remover");

		btn_Remover.setBounds(311, 110, 89, 23);
		contentPane.add(btn_Remover);

		JButton btn_Atualizar = new JButton("Atualizar");

		btn_Atualizar.setBounds(311, 181, 89, 23);
		contentPane.add(btn_Atualizar);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Oficina().setVisible(true);
				fecharJFrame();
			}
		});
		btn_Voltar.setBounds(296, 11, 114, 23);
		contentPane.add(btn_Voltar);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setBounds(27, 301, 223, 16);
		contentPane.add(lbl_error);

		final JList list_compras = new JList();
		list_compras.setBounds(24, 29, 252, 229);
		final DefaultListModel model = new DefaultListModel();

		for(Iterator<Compra> iter = OficinaFacade.comprasIterator();iter.hasNext();){
			Compra compra = (Compra)iter.next();
			try {
				model.addElement(compra.getId() + "(" + OficinaFacade.buscarConta(compra.getContaCPF()).getNome() +")");
			} catch (ContaNaoExisteException e1) {
				e1.printStackTrace();
			} catch (CPFInvalidoException e1) {
				e1.printStackTrace();
			}
		}


		list_compras.setModel(model);
		contentPane.add(list_compras);

		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!OficinaFacade.contaIterator().hasNext()){ //Pois senao a compra nao existira.
					lbl_error.setText("Nao Existem contas cadastradas para efetuarem compras.");
				}else if(!OficinaFacade.servicoIterator().hasNext()){
					lbl_error.setText("N�o existem servi�os cadastrados para se constituir uma compra");
				}else{
					new CadastrarCompra().setVisible(true);
					fecharJFrame();
				}
			}
		});

		btn_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_compras.getSelectedValue() != null){
					String ID = list_compras.getSelectedValue().toString().substring(list_compras.getSelectedValue().toString().indexOf("(", 0)+1,list_compras.getSelectedValue().toString().length()-1);
					try {
						OficinaFacade.removerServico(ID);
						model.removeElement(list_compras.getSelectedValue());
					} catch (ServicoNaoEncontradoException e1) {
						e1.printStackTrace();
					}
				}else{
					lbl_error.setText("Nenhum cliente selecionado.");
				}
			}
		});

		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = list_compras.getSelectedValue().toString().substring(0,list_compras.getSelectedValue().toString().indexOf("("));
				AtualizarCompra frame = new AtualizarCompra();
				frame.setVisible(true);

				try {
					frame.selecionarDados(OficinaFacade.buscarCompra(ID));
				} catch (CompraNaoExisteException e1) {
					e1.printStackTrace();
				} //Passa os dados necessarios de uma GUI para a outra.

				fecharJFrame();

			}
		});


	}

	protected void fecharJFrame() {
		this.dispose();
	}
}
