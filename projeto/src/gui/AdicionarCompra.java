package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdicionarCompra extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tf_CPF;
	private JTextField tf_valorapagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarCompra frame = new AdicionarCompra();
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
	public AdicionarCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list_disponiveis = new JList();
		list_disponiveis.setBounds(27, 88, 173, 229);
		contentPane.add(list_disponiveis);
		
		JLabel lblListaDeServios = new JLabel("Lista de Servi\u00E7os Dispon\u00EDveis");
		lblListaDeServios.setBounds(27, 53, 145, 24);
		contentPane.add(lblListaDeServios);
		
		JList list_comprados = new JList();
		list_comprados.setBounds(253, 88, 173, 229);
		contentPane.add(list_comprados);
		
		JLabel lblListaDeServios_1 = new JLabel("Lista de Servi\u00E7os Comprados");
		lblListaDeServios_1.setBounds(253, 53, 145, 24);
		contentPane.add(lblListaDeServios_1);
		
		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.setBounds(290, 360, 136, 23);
		contentPane.add(btnFinalizarCompra);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(337, 0, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNomeDoComprador = new JLabel("Nome do Comprador");
		lblNomeDoComprador.setBounds(28, 28, 104, 14);
		contentPane.add(lblNomeDoComprador);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(142, 25, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpfDoComprador = new JLabel("CPF do Comprador");
		lblCpfDoComprador.setBounds(27, 4, 105, 14);
		contentPane.add(lblCpfDoComprador);
		
		tf_CPF = new JTextField();
		tf_CPF.setBounds(142, 1, 161, 20);
		contentPane.add(tf_CPF);
		tf_CPF.setColumns(10);
		
		JLabel lblValorPagar = new JLabel("Valor \u00E0 Pagar:");
		lblValorPagar.setBounds(27, 328, 82, 14);
		contentPane.add(lblValorPagar);
		
		tf_valorapagar = new JTextField();
		tf_valorapagar.setEditable(false);
		tf_valorapagar.setColumns(10);
		tf_valorapagar.setBounds(100, 328, 104, 20);
		contentPane.add(tf_valorapagar);
	}
}
