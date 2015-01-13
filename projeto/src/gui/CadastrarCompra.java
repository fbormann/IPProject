package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CadastrarCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCompra frame = new CadastrarCompra();
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
	public CadastrarCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//TODO: Criar uma Lista Onde tem todos os Servicos chamda "Servicos" e outra chamada "Compra" 
		//TODO: Criar Botao "Add" para uma segunda lista chamda "Compra"
		//TODO: Criar Botao "Delete" que retira o item selecionado da lista "Compra"
		//TODO: Criar Botao "Finalizar Compra" que finaliza a compra e abre a tela "Oficina"
	}

}
