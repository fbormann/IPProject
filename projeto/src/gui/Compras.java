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
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setBounds(205, 181, -151, -143);
		final DefaultListModel model = new DefaultListModel();
		if(OficinaFacade.comprasArray != null){
			Compra[] compras = OficinaFacade.comprasArray.listar();
			if(compras != null){
				for(int i = 0; i < compras.length;i++){
					try {
						model.addElement(compras[i].getId() + "(" + OficinaFacade.buscarConta(compras[i].getContaCPF()).getNome() +")"); //TODO: Checar as compras pois quando deletarmos uma conta, devemos deletar as compras relacionados à elas.
					} catch (ContaNaoExisteException e1) {
						e1.printStackTrace();
					} catch (CPFInvalidoException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		list.setModel(model);
		contentPane.add(list);
		
		
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdicionarCompra().setVisible(true);
				fecharJFrame();
			}

			
		});
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
		btn_Voltar.setBounds(296, 11, 114, 23);
		contentPane.add(btn_Voltar);
		
		//TODO: Criar uma Lista Onde tem todos os Servicos chamda "Servicos" e outra chamada "Compra" 
		//TODO: Criar Botao "Add" para uma segunda lista chamda "Compra"
		//TODO: Criar Botao "Delete" que retira o item selecionado da lista "Compra"
		//TODO: Criar Botao "Finalizar Compra" que finaliza a compra e abre a tela "Oficina"
	}

	protected void fecharJFrame() {
		this.dispose();
	}
}
