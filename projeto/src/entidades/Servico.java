package entidades;

public abstract class Servico {
	private String nome;
	private double preco;
	private String ID;
	
	public Servico(String nome,double preco, String ID){
		this.preco = preco;
		this.nome = nome;
		this.ID = ID;
	}
	
	public Servico(){
		
	}
	
	public abstract double comissao(Compra compra);
	
	public String getNome(){
		return this.nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getID() {
		return this.ID;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String toString(){
		String r = "Servico: " + "\nNome: " + this.nome + "\nPreco: " + this.preco + "\nID: " + this.ID; 
		return r;
	}
	

}
