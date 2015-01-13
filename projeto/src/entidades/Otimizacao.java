package entidades;

public class Otimizacao extends Servico {
	
	private static final double c2 = 0.2;
	
	public Otimizacao(String nome,double preco, String ID){
		super(nome,preco, ID);
	}
	
	public double comissao(double compra){
		double r = (compra * c2);
		return r;
	}
	

}
