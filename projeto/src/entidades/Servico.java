package entidades;

public abstract class Servico {
	private double preco;
	private String ID;
	
	public Servico(double preco, String ID){
		this.preco = preco;
		this.ID = ID;
	}

	public abstract double comissao(double compra);

	public double getPreco() {
		return this.preco;
	}

	public String getID() {
		return this.ID;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String toString(){
		String r = "Serviço: " + "\nPreco: " + this.preco + "\nID: " + this.ID; 
		return r;
	}
	

}
