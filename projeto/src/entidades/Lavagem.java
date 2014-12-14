package entidades;

public class Lavagem extends Servico {
	
	private static final double c1 = 0.1;
	
	public Lavagem(double preco, String ID){
		super(preco, ID);
	}
	
	public double comissao(double compra){
		double r = (compra * c1);
		return r;
	}
	

}
