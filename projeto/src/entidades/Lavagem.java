package entidades;

public class Lavagem extends Servico {
	
	private static final double c1 = 0.1;
	
	public Lavagem(double preco, String ID, String codigo){
		super(preco, ID, codigo);
	}
	
	public double comissao(double compra){
		double r = (compra * c1);
		return r;
	}
	

}
