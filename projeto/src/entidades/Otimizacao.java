package entidades;

public class Otimizacao extends Servico {
	
	private static final double c2 = 0.2;
	
	public Otimizacao(double preco, String ID, String codigo){
		super(preco, ID, codigo);
	}
	
	public double comissao(double compra){
		double r = (compra * c2);
		return r;
	}
	

}
