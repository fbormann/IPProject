package entidades;

//venda representa a venda de produtos como oleo, etc
public class Venda extends Servico {
	
	private final double COMISSAO;

	public Venda( String nome,double preco, String ID){
		super(nome,preco, ID);
		this.COMISSAO = 0;
	}
	
	public double comissao(double compra){
		return compra*this.COMISSAO; //TODO:ver isto aqui.
	}


}
