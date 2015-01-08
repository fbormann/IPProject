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

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(294, 186, 89, 23);
		contentPane.add(btnSalvar);

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
		//		
		//		table = new JTable();
		//		table.setBounds(10, 41, 252, 210);
		//		contentPane.add(table);
		//		


		DefaultListModel model = new DefaultListModel();
		if(OficinaFacade.contasArray != null){
			Conta[] contas = OficinaFacade.contasArray.listar();
			if(contas != null){
				for(int i = 0; i < contas.length;i++){
					model.addElement(contas[i].getNome());
				}
			}
		}
	
		model.addElement("teste");

		JList list_clientes = new JList(model);
		list_clientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(list_clientes);
		JScrollPane teste = new JScrollPane();
		teste.setViewportView(list_clientes);


	}

	public void listarClientes(){

	}

	public void fecharJFrame(){
		this.dispose();

	}
}
