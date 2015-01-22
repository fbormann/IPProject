package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Oficina extends JFrame {

	private JPanel contentPane;
	private JButton btnVendas;
	private JButton btnClientes;
	private JButton btnServios;
	private JButton btnHistrico;
	private JTextField txtNomeLogo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oficina frame = new Oficina();
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
	public Oficina() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVendas = new JButton("Compras");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Compras().setVisible(true);
				fecharJFrame();
			}
		});
		btnVendas.setBounds(20, 37, 117, 29);
		contentPane.add(btnVendas);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Clientes().setVisible(true);
				fecharJFrame();
			}
		});
		btnClientes.setBounds(174, 37, 117, 29);
		contentPane.add(btnClientes);
		
		btnServios = new JButton("Servi\u00E7os");
		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ServicoGUI().setVisible(true);
				fecharJFrame();
			}
		});
		btnServios.setBounds(327, 37, 117, 29);
		contentPane.add(btnServios);
		
		btnHistrico = new JButton("Hist\u00F3rico");
		btnHistrico.setBounds(327, 231, 117, 29);
		contentPane.add(btnHistrico);
		
		txtNomeLogo = new JTextField();
		txtNomeLogo.setText("nome + logo");
		txtNomeLogo.setBounds(180, 119, 134, 28);
		contentPane.add(txtNomeLogo);
		txtNomeLogo.setColumns(10);
	}
	public void fecharJFrame(){
		this.dispose();
	}
	
}
