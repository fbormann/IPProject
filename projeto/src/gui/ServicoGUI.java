package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import comunicacao.OficinaFacade;
import entidades.Compra;
import entidades.Servico;
import excecoes.CPFInvalidoException;
import excecoes.ContaNaoExisteException;
import excecoes.ServicoNaoEncontradoException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServicoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicoGUI frame = new ServicoGUI();
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
	public ServicoGUI() {
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
		
		JLabel lblServicos = new JLabel("Servicos");
		lblServicos.setBounds(103, 11, 76, 14);
		panel.add(lblServicos);
		
		JButton btn_Remover = new JButton("Remover");
		
		btn_Remover.setBounds(294, 121, 89, 23);
		panel.add(btn_Remover);
		
		JButton btn_Atualizar = new JButton("Atualizar");
	
		btn_Atualizar.setBounds(294, 186, 89, 23);
		panel.add(btn_Atualizar);
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarServico().setVisible(true);
				fecharJFrame();
			}
		});
		btn_Cadastrar.setBounds(294, 56, 89, 23);
		panel.add(btn_Cadastrar);
		
		final JList list_servicos = new JList();
		list_servicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_servicos.setBounds(26, 44, 204, 165);
		
		final DefaultListModel model = new DefaultListModel();
		if(OficinaFacade.servicosArray != null){
			Servico[] servicos = OficinaFacade.servicosArray.listar();
			if(servicos != null){
				for(int i = 0; i < servicos.length;i++){
						model.addElement(servicos[i].getNome() + "(" + servicos[i].getID() +")"); 
				}
			}
		}
		list_servicos.setModel(model);
		panel.add(list_servicos);
		
		final JLabel lbl_error = new JLabel("");
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(26, 237, 204, 14);
		panel.add(lbl_error);
		
		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Oficina().setVisible(true);
				fecharJFrame();
			}
		});
		button_3.setBounds(294, 7, 119, 23);
		panel.add(button_3);
		
		btn_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list_servicos.getSelectedValue() != null){
					String ID = list_servicos.getSelectedValue().toString().substring(list_servicos.getSelectedValue().toString().indexOf("(", 0)+1,list_servicos.getSelectedValue().toString().length()-1);
					try {
						OficinaFacade.removerServico(ID);
						model.removeElement(list_servicos.getSelectedValue());
					} catch (ServicoNaoEncontradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			
				}else{
					lbl_error.setText("Nenhum cliente selecionado.");
				}
			}
		});
		
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = list_servicos.getSelectedValue().toString().substring(list_servicos.getSelectedValue().toString().indexOf("(", 0)+1,list_servicos.getSelectedValue().toString().length()-1);
				AtualizarServico frame = new AtualizarServico();
				frame.setVisible(true);
				try {
					frame.selecionarDados(OficinaFacade.buscarServico(ID));
				} catch (ServicoNaoEncontradoException e) {
					lbl_error.setText("Servico Nao Encontrado");
					e.printStackTrace();
				}
				fecharJFrame();
			}
		});
	}
	
	public void fecharJFrame(){
		this.dispose();
	}

}
