package entidades;

public class Lavagem extends Servico {
	
	private static final double c1 = 0.1;
	
	public Lavagem(String nome,double preco, String ID){
		super(nome,preco, ID);
	}
	
	public Lavagem(){
		
	}

	public double comissao(Compra compra){
		double r = (compra.totalCompra() * c1);
		return r;
	}
	

}
