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
import excecoes.ContaNaoExisteException;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_Cadastrar = new JButton("Cadastrar");

		btn_Cadastrar.setBounds(311, 47, 89, 23);
		contentPane.add(btn_Cadastrar);

		JButton btn_Remover = new JButton("Remover");
		btn_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Remover.setBounds(311, 110, 89, 23);
		contentPane.add(btn_Remover);

		JButton btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		lbl_error.setBounds(24, 242, 223, 16);
		contentPane.add(lbl_error);

		JList list_compras = new JList();
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
				}else{
					new CadastrarCompra().setVisible(true);
					fecharJFrame();
				}
			}
		});

		//TODO: Criar uma Lista Onde tem todos os Servicos chamda "Servicos" e outra chamada "Compra" 
		//TODO: Criar Botao "Add" para uma segunda lista chamda "Compra"
		//TODO: Criar Botao "Delete" que retira o item selecionado da lista "Compra"
		//TODO: Criar Botao "Finalizar Compra" que finaliza a compra e abre a tela "Oficina"
	}

	protected void fecharJFrame() {
		this.dispose();
	}
}
