package entidades;

/*
 * Representa um produto vendido na Oficina.
 * */
public class Produto extends Servico{ 

	public Produto(String nome, double preco, String ID) {
		super(nome, preco, ID);
	}

	public double comissao(double compra) {
		// TODO: Create a comissao value
		return 0;
	}

}
