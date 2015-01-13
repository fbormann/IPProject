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

import javax.swing.ListSelectionModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;



public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(26, 44, 59, 63);
		if(OficinaFacade.contasArray != null){
			Conta[] contas = OficinaFacade.contasArray.listar();
			if(contas != null){
				for(int i = 0; i < contas.length;i++){
					model.addElement(contas[i].getNome());
				}
			}
		}
		list.setModel(model);
		contentPane.add(list);
		
		//TODO: Implementar o m�todo Update e o m�todo Remover na Lista de Clientes.
		
	
	
		


	}

	public void listarClientes(){

	}

	public void fecharJFrame(){
		this.dispose();

	}
}
