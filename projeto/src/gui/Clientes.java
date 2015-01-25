package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import comunicacao.OficinaFacade;
import entidades.Conta;
import excecoes.CPFInvalidoException;
import excecoes.ContaNaoExisteException;

import javax.swing.ListSelectionModel;



import java.awt.event.ActionEvent;

import javax.swing.AbstractListModel;

import java.awt.Color;
import java.util.Iterator;



public class Clientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(103, 11, 46, 14);
		contentPane.add(lblClientes);

		JButton btnRemover = new JButton("Remover");

		btnRemover.setBounds(294, 121, 89, 23);
		contentPane.add(btnRemover);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAtualizar.setBounds(294, 186, 89, 23);
		contentPane.add(btnAtualizar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(294, 56, 89, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarClientes().setVisible(true);
				fecharJFrame();
			}
		});
		btnCadastrar.setBounds(294, 56, 89, 23);
		contentPane.add(btnCadastrar);

		final DefaultListModel model = new DefaultListModel();
		final JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(26, 44, 204, 165);


		for(Iterator<Conta> iter = OficinaFacade.contaIterator(); iter.hasNext();){
			Conta conta = iter.next();
			model.addElement(conta.getNome() + "(" + conta.getCPF() +")");
		}



		list.setModel(model);
		contentPane.add(list);

		final JLabel lbl_error = new JLabel("");
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(26, 237, 204, 14);
		contentPane.add(lbl_error);

		JButton btn_back = new JButton("Voltar");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Oficina().setVisible(true);
				fecharJFrame();
			}
		});
		btn_back.setBounds(294, 7, 119, 23);
		contentPane.add(btn_back);


		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(list.getSelectedValue() != null){
					String CPF = list.getSelectedValue().toString().substring(list.getSelectedValue().toString().indexOf("(", 0)+1,list.getSelectedValue().toString().length()-1);

					try {
						OficinaFacade.removerConta(CPF);
						model.removeElement(list.getSelectedValue());
					} catch (ContaNaoExisteException e) {
						//Esses erros n�o acontecer�o.
						e.printStackTrace();
					} catch (CPFInvalidoException e) {
						//Este erro n�o acontecer�.
						e.printStackTrace();
					}			
				}else{
					lbl_error.setText("Nenhum cliente selecionado.");
				}

			}
		});

		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue() != null){
					String CPF = list.getSelectedValue().toString().substring(list.getSelectedValue().toString().indexOf("(", 0)+1,list.getSelectedValue().toString().length()-1);
					try {
						Conta aux = OficinaFacade.buscarConta(CPF);
						AtualizarCliente frame = new AtualizarCliente();
						frame.setVisible(true);
						frame.addDados(aux);
						fecharJFrame();
					} catch (ContaNaoExisteException e1) {
						lbl_error.setText(e1.getMessage());
					} catch (CPFInvalidoException e1) {
						lbl_error.setText(e1.getMessage());
					}
				}else{
					lbl_error.setText("Nenhum cliente selecionado.");
				}
			}
		});


	}


	public void fecharJFrame(){
		this.dispose();

	}
}
