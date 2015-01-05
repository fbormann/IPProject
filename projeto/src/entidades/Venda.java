package entidades;

//venda representa a venda de produtos como oleo, etc
public class Venda extends Servico {
	
	private final double COMISSAO;

	public Venda(double preco, String ID, String codigo){
		super(preco, ID, codigo);
		this.COMISSAO = 0;
	}
	
	public double comissao(double compra){
		return 0;
	}


}
