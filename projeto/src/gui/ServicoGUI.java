package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
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
		
		JButton button = new JButton("Remover");
		button.setBounds(294, 121, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Atualizar");
		button_1.setBounds(294, 186, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Cadastrar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarServico().setVisible(true);
				fecharJFrame();
			}
		});
		button_2.setBounds(294, 56, 89, 23);
		panel.add(button_2);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(26, 44, 204, 165);
		panel.add(list);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBounds(26, 237, 204, 14);
		panel.add(label_1);
		
		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Oficina().setVisible(true);
				fecharJFrame();
			}
		});
		button_3.setBounds(294, 7, 119, 23);
		panel.add(button_3);
	}
	
	public void fecharJFrame(){
		this.dispose();
	}

}
