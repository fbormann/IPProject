package entidades;

/*
 * Representa um produto vendido na Oficina.
 * */
public class Produto extends Servico{ 

	private static final double C1 = 0.3;
	
	public Produto(String nome, double preco, String ID) {
		super(nome, preco, ID);
	}
	
	public Produto(){
	
	}

	public double comissao(Compra compra) {
		double r = (compra.totalCompra() * C1);
		return r;
	}

}
