package entidades;

public class Otimizacao extends Servico {
	
	private static final double c2 = 0.2;
	
	public Otimizacao(String nome,double preco, String ID){
		super(nome,preco, ID);
	}

	public double comissao(Compra compra){
		double r = (compra.totalCompra() * c2);
		return r;
	}
	

}
