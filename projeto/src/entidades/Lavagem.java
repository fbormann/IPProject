package entidades;

public class Lavagem extends Servico {
	
	private static final double c1 = 0.1;
	
	public Lavagem(String nome,double preco, String ID){
		super(nome,preco, ID);
	}
	
	public double comissao(double compra){
		double r = (compra * c1);
		return r;
	}
	

}
